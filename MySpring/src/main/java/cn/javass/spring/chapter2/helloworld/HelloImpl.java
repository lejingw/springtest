package cn.javass.spring.chapter2.helloworld;

public class HelloImpl implements HelloApi {
	private String msg;
	public HelloImpl(){
		System.out.println("===="+this);
	}
	public void setMsg(String msg){
		this.msg = msg;
	}

    @Override
    public void sayHello() {
        System.out.println("Hello World!" + msg + this);
    }
    
    public void destroy() {
        System.out.println("de");
    }
}
