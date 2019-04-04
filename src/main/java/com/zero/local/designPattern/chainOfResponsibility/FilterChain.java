package com.zero.local.designPattern.chainOfResponsibility;

public class FilterChain {
    private Node<Filter> node;

    public FilterChain addFilter(Filter filter){
        if(node == null){
            node = new Node<>();
            node.first = node;

        }
        return this;
    }

    public void doFilter(Request request,Response response){
        /*while(true){
            Filter filter = filterQueue.poll();
            if(filter == null){
                break;
            }
            filter.doFilter(request,response,this);
        }*/
    }
}
