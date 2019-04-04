package com.zero.local.designPattern.chainOfResponsibility;

public class MainApp {
    public static void main(String[] args) {
        Request request = new Request();
        request.setRequestStr("fuck,what a shit man you are!");
        Response response = new Response();
        Filter filter1 = new FuckFilter();
        Filter filter2 = new ShitFilter();
        FilterChain chain = new FilterChain();
        chain.addFilter(filter1).addFilter(filter2);
        chain.doFilter(request,response);
        System.out.println(request.getRequestStr());
    }
}
