package com.enviro.assessment.grad001.zamagcina_ngeyane.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The HomeController class provides a simple endpoint for the root URL ("/") that serves a welcome HTML page.
 * This page includes links to the available API endpoints for disposal guidelines, recycling tips, and waste categories.
 */
@RestController
public class HomeController {

    /**
     * The home method handles GET requests to the root URL ("/").
     * It returns an HTML page with a welcome message and links to the API endpoints for disposal guidelines,
     * recycling tips, and waste categories.
     *
     * @return An HTML string containing a welcome message and links to available API endpoints.
     */
    @GetMapping("/")
    public String home() {
        // Returns a simple HTML page with links to the available API endpoints
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
