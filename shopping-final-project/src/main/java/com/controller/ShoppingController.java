package com.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.bean.BillDetails;
import com.bean.Order;
import com.bean.OrderItem;
import com.bean.Shopping;
import com.service.ShoppingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoppingController {

	@Autowired
	private ShoppingService shoppingService;

	@RequestMapping("/")
	public String openingPageController(HttpSession session) {
		session.setAttribute("listOfProducts", null);
		return "index";
	}

	@RequestMapping("/selectProducts")
	public ModelAndView getProductId() {
		return new ModelAndView("selectProducts", "command", new Shopping(0, null, 0, 1));
	}

	@ModelAttribute("products")
	List<Shopping> getProductIds() {
		List<Shopping> shopping = null;

		try {
			shopping = shoppingService.getProductList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shopping;
	}

	@RequestMapping("/viewAllProducts")
	public ModelAndView displayProductDetailsController(HttpSession session) {
		List<Shopping> shoppingList = shoppingService.getProductList();
		if (shoppingList.size() > 0) {
			session.setAttribute("shoppingList", shoppingList);
			System.out.println(shoppingList);
			return new ModelAndView("displayProductDetails", "shoppingList", shoppingList);
		} else {
			return new ModelAndView("output", "message", "Error, Please try again.");
		}
	}

	@RequestMapping("/saveProduct")
	public ModelAndView selectProductById(@RequestParam("operation") String operation,
			@ModelAttribute("commmand") Shopping shop, HttpSession session) {
		Shopping shopping = null;
		List<Shopping> allProductsShoppingList = (ArrayList<Shopping>) session.getAttribute("shoppingList");
		System.out.println("List in Save Product: " + allProductsShoppingList);
		if (allProductsShoppingList == null) {
			allProductsShoppingList = new ArrayList<>();
		}
		shopping = allProductsShoppingList.stream().filter(x -> x.getId() == shop.getId()).collect(Collectors.toList())
				.get(0);
		shopping.setQuantityAvailable(shop.getQuantityAvailable());
		shopping.setPrice(shopping.getQuantityAvailable() * shopping.getPrice());
		List<Shopping> cartList = (ArrayList<Shopping>) session.getAttribute("listOfProducts");
		if (cartList == null)
			cartList = new ArrayList<Shopping>();

		switch (operation) {
		case "Add More":
			if (!cartList.contains(shopping)) {
				cartList.add(shopping);
				session.setAttribute("listOfProducts", cartList);
			}
			return new ModelAndView("selectProducts", "command", new Shopping(0, null, 0, 1));

		case "Save":
			if (!cartList.contains(shopping)) {
				cartList.add(shopping);
				session.setAttribute("listOfProducts", cartList);
			}
			if (cartList.size() != 0) {
				return new ModelAndView("displayCart", "cartList", cartList);
			}
			break;
		}

		return new ModelAndView("output", "message", "Cart is Empty ! ");
	}

	@RequestMapping("/buyProduct")
	public ModelAndView buyProductController() {
		return new ModelAndView("customerDetails", "command", new Order());
	}

	@RequestMapping("/productPurchased")
	public ModelAndView purchaseProductController(@ModelAttribute("command") Order order, HttpSession session) {
		List<Shopping> shoppingListOfCustomer = (ArrayList<Shopping>) session.getAttribute("listOfProducts");
		List<OrderItem> items = new ArrayList<>();
		OrderItem oItem = null;
		int orderId = shoppingService.getHighestOrderId();
		int orderItemId = shoppingService.getHighestOrderItemId();
		System.out.println("Order ID" + orderId);
		System.out.println(orderItemId);
		for (Shopping shop : shoppingListOfCustomer) {
			oItem = new OrderItem(orderItemId + 1, shop.getId(), shop.getQuantityAvailable(),
					(float) (shop.getPrice() / shop.getQuantityAvailable()), shop.getPrice());
			orderItemId += 1;
			items.add(oItem);
		}
		order.setId(orderId + 1);
		order.setItems(items);

		if (shoppingService.saveOrder(order) != null) {
			double amount = shoppingListOfCustomer.stream().mapToDouble(x -> x.getPrice()).sum();
			shoppingService.reduceQuantityOfPurchasedProducts(order);
			return new ModelAndView("displayBillDetails", "billDetails",new BillDetails(order, shoppingListOfCustomer, amount));
		} else
			return new ModelAndView("output", "message", "Error! Please try again");
	}
}
