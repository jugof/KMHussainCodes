package app;

import tourism.SiteStore;

public class Program {
    
    public static void main(String[] args) throws Exception {
        var mysite = SiteStore.load("CitiZoo");
        if(args.length > 0){
            var guest = mysite.getVisitor(args[0]);
            guest.visit();
            mysite.persist();
            System.out.printf("Welcome %s, your ticket number is %d%n", guest.getName(), guest.getTicketNumber());
        }else{
            for(var visitor : mysite.getVisitors()){
                System.out.printf("%s\t%d\t%s%n", visitor.getName(), visitor.getVisitCount(), visitor.getLastVisit());
            }
        }
    }
}

