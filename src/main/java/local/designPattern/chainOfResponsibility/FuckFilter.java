package local.designPattern.chainOfResponsibility;

public class FuckFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        String requestStr = request.getRequestStr();
        String replace = requestStr.replace("fuck", "love");
        request.setRequestStr(replace);
        //chain.doFilter(request,response);
    }
}
