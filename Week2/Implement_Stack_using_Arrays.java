public class Implement_Stack_using_Arrays{

    static int[]stack = new int[1000000];
    int top  = -1;

    public void push(int value){
        if(top == stack.length-1){
            System.out.println("Stack overflow");
            return;
        }
        stack[++top] = value;
    }
    public int pop(){
        if(top == -1){
            System.out.println("Stack is Empty");
            return -1;
        }
        return stack[top--];
    }
    public int peek(){
        if(top  == -1){
            System.out.println("Stack is Empty");
            return -1;
        }
        return stack[top];
    }
    public void isEmpty(){
        if(top == -1){
            System.out.println("Stack is Empty");
        }else{
            System.out.println("Stack is not Empty");
        }
    }
    public static void main(String[] args) {
        Implement_Stack_using_Arrays s = new Implement_Stack_using_Arrays();
        s.pop();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        System.out.println(s.peek()) ;    
        System.out.println(s.pop()) ;
        System.out.println(s.peek()) ;    
        s.isEmpty();  
    }
}
