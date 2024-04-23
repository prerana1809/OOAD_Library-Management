// package com.example.Payment.payment.controller;

// import com.example.Payment.payment.model.BorrowCart;
// import com.example.Payment.payment.model.BuyCart;
// import com.example.Payment.payment.model.CartItem;
// import com.example.Payment.payment.model.CartRequest; // Make sure to import the new DTO
// import com.example.Payment.payment.service.CartService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.SessionAttribute;

// @RestController
// @RequestMapping("/cart")
// public class CartController {

//     @Autowired
//     private CartService cartService;

//     @PostMapping("/add")
//     public String addToCart(@RequestBody CartRequest cartRequest,
//                         @SessionAttribute("borrowCart") BorrowCart borrowCart,
//                         @SessionAttribute("buyCart") BuyCart buyCart) {
//     System.out.println("Received cart request: " + cartRequest);
//         CartItem item = new CartItem(cartRequest.getMaterialId(), cartRequest.getQuantity());
//         if ("borrow".equals(cartRequest.getCartType())) {
//             cartService.addToBorrowCart(borrowCart, item);
//             return "Added to Borrow Cart";
//         } else {
//             cartService.addToBuyCart(buyCart, item);
//             return "Added to Buy Cart";
//         }
//     }
// }
