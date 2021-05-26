package org.orakris;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Insurance insurance = new Insurance();
        insurance.setId(1);
        insurance.setName("vehicle policy");
        insurance.setAmount(100000);
        insurance.setTenure(10);
        
    }
}
