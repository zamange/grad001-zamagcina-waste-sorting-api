package com.enviro.assessment.grad001.zamagcina_ngeyane.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return """
               <html>
                   <head>
                       <title>Welcome</title>
                   </head>
                   <body>
                       <h1>Welcome to the Waste Management API</h1>
                       <p>Available endpoints:</p>
                       <ul>
                           <li><a href="/api/disposal-guidelines">Disposal Guidelines</a></li>
                           <li><a href="/api/recycling-tips">Recycling Tips</a></li>
                           <li><a href="/api/waste-categories">Waste Categories</a></li>
                       </ul>
                   </body>
               </html>
               """;
    }
}
