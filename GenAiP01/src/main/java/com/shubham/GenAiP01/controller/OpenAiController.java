package com.shubham.GenAiP01.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for handling AI chat requests.
 * This controller uses Spring AI's ChatClient to interact with the AI model.
 */
@RestController
@RequestMapping("/api")
public class OpenAiController {

    // ChatClient is used to send prompts to the AI model and receive responses
    private final ChatClient chatClient;

    /**
     * Constructor-based dependency injection.
     * ChatClient.Builder is provided by Spring Boot configuration.
     */
    public OpenAiController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    /**
     * API Endpoint: /api/chat
     * Method: GET
     *
     * @param msg - User input message passed as query parameter
     * @return AI-generated response as String
     *
     * Example:
     * http://localhost:8080/api/chat?msg=Hello
     */
    @GetMapping("/chat")
    public String chatOpenAIModel(@RequestParam("msg") String msg){

        // Send user message to AI model and return generated response
        return chatClient
                .prompt(msg)   // Pass user input as prompt
                .call()        // Call the AI model
                .content();    // Extract response text
    }
}