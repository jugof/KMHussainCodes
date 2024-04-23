package app.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import app.components.Counter;

@Controller
public class GreeterController {
    
    @Autowired
    private Counter ctr;

    @GetMapping("/greet")
    @ResponseBody
    public String welcome() {
        return String.format("""
                <html>
                    <head>
                        <title>demo-web-app</title>
                    </head>
                    <body>
                        <h1>Welcome Visitor</h1>
                        <p>
                            <b>Current Time: </b>%s
                        </p>
                        <form method="post" action="/count">
                            <b>Name: </b>
                            <input type="text" name="person"/>
                            <input type="submit" value="Greet"/>
                        </form>
                    </body>
                </html>
                """, new Date());
    }

    @PostMapping("/count")
    @ResponseBody
    public String hello(@RequestParam(name = "person", defaultValue = "Visitor") String id) {
        int count = ctr.countNext(id);
        return String.format("""
                <html>
                    <head>
                        <title>demo-web-app</title>
                    </head>
                    <body>
                        <h1>Hello %s</h1>
                        <p>
                            <b>Number of Greetings: </b>%d
                        </p>
                    </body>
                </html>
                """, id, count);
    }

}
