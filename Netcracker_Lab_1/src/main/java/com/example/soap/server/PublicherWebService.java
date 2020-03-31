package com.example.soap.server;

import javax.xml.ws.Endpoint;


/***
 * ТОчка входа в soap- среврере
 */
public class PublicherWebService {

    public static void main(String... args) {

        Endpoint.publish("http://localhost:1234/wss/persons", new WebServieImpl());
    }

}
