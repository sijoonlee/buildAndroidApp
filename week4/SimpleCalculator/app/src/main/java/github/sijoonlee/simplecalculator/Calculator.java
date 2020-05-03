package github.sijoonlee.simplecalculator;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Sijoon
 */
public class Calculator {
    private ArrayList<String> buffer;
    private ArrayList<String> operators;

    public Calculator(){
        buffer = new ArrayList<>();
        operators = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));
    }
    public void clearBuffer(){
        buffer.clear();
    }
    public boolean deleteLastOne(){
        if(buffer.size() == 0)
            return false;
        String lastItem = buffer.get(buffer.size()-1);
        if (lastItem.length() > 1) {
            buffer.set(buffer.size()-1, lastItem.substring(0, lastItem.length()-1));
        } else {
            buffer.remove(buffer.size()-1 );
        }
        return true;
    }


    public ArrayList<String> getBuffer(){
        return buffer;
    }
    public int sizeOfBuffer(){
        return buffer.size();
    }
    public boolean doesEndwithDot(String a){
        if(a.endsWith("."))
            return true;
        return false;
    }

    public boolean isOperator(String a){
        for ( String op : operators ){
            if( op == a ){
                return true;
            }
        }
        return false;
    }

    public boolean isNumbWithoutDot(String a){
        if(isOperator(a) || doesEndwithDot(a))
            return false;
        return true;
    }

    public boolean addToBuffer(String a){


        if(buffer.size() == 0){
            if(isOperator(a)){
                return false;
            } else {
                buffer.add(a);
                return true;
            }
        }

        String lastItem = buffer.get(buffer.size()-1);
        boolean isAdded = false;

        if(isOperator(lastItem)){
            if(doesEndwithDot(a)){
                buffer.add("0.");
                isAdded = true;
            } else if (isNumbWithoutDot(a)) {
                buffer.add(a);
                isAdded = true;
            }
        } else if(doesEndwithDot(lastItem)) {
            if(isNumbWithoutDot(a)){
                buffer.set(buffer.size()-1, lastItem + a);
                isAdded = true;
            } else if(isOperator(a)) {
                buffer.add(a);
                isAdded = true;
            }
        } else if(isNumbWithoutDot(lastItem)){
            if(isOperator(a)){
                buffer.add(a);
                isAdded = true;
            } else if(isNumbWithoutDot(a)){
                buffer.set(buffer.size()-1, lastItem + a);
                isAdded = true;
            } else if(doesEndwithDot(a)){
                buffer.set(buffer.size()-1, lastItem + a);
                isAdded = true;
            }
        }

        return isAdded;
    }
    interface IMath {
        double perform(double a, double b);
    }
    public IMath createOperation(String op){
        IMath iMath;
        if(op.equals("*")){
            iMath = (double a, double b) -> a * b;
        } else if (op.equals("/")){
            iMath = (double a, double b) -> a / b;
        } else if (op.equals("+")){
            iMath = (double a, double b) -> a + b;
        } else {// (op.equals("-")){
            iMath = (double a, double b) -> a - b;
        }
        return iMath;
    }
    public String performOperation(int idx){
        double result = createOperation(buffer.get(idx)).perform(
                Double.parseDouble(buffer.get(idx-1)),
                Double.parseDouble(buffer.get(idx+1)));
        return Double.toString(result);
    }

    public void calInnerOp(String op1, String op2, int i){
        if(buffer.get(i).equals(op1) || buffer.get(i).equals(op2)){
            buffer.set(i-1, performOperation(i));
            buffer.remove(i);
            buffer.remove(i);
        }
    }

    public double cal(){
        int position = 1;
        int size = buffer.size();
        while(buffer.size()>2){
            calInnerOp("*", "/", position);
            position += 2 + (buffer.size()-size);
            size = buffer.size();
            if(position >= buffer.size())
                break;
//            System.out.println("------");
//            showBuffer();
        }
        position = 1;
        while(buffer.size()>2){
            calInnerOp("+", "-", position);
            position += 2 + (buffer.size()-size);
            size = buffer.size();
            if(position >= buffer.size())
                break;
        }
        return Double.parseDouble(buffer.get(0));
    }

//    public void showBuffer(){
//        for(int i=0; i<buffer.size();i++){
//            System.out.println(buffer.get(i));
//        }
//    }
}
