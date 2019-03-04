package designPattern.chainOfResponsibility;

public class ShitFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        String requestStr = request.getRequestStr();
        String replace = requestStr.replace("shit", "great");
        request.setRequestStr(replace);
        //chain.doFilter(request,response);
    }
}
