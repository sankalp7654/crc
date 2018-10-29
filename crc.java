package ComputerNetworksLabInternals;

import java.util.Scanner;

public class CRC {

    static int divisor[];
    static int div[];
    static int data[];
    static int remainder[];
    static int crc[];
    
    public static void main(String [] args)
    {
        
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the number of elements in data");
        int data_size=sc.nextInt();
        data=new int[data_size];
        System.out.println("Enter the data");
        for(int i=0;i<data_size;i++)
        {
            data[i]=sc.nextInt();
        }
        
        System.out.println("Enter the number of elements in divisor");
        int div_size=sc.nextInt();
        div=new int[div_size];
        System.out.println("Enter the divisor");
        for(int i=0;i<div_size;i++)
        {
            div[i]=sc.nextInt();
        }
        
        
        int total_length=data.length +div.length-1;
        divisor=new int[total_length];
        remainder=new int[total_length];
        crc=new int[total_length];
        
        for(int i=0;i<data.length;i++)
        {
            divisor[i]=data[i];
            remainder[i]=data[i];
        }
        
        //System.out.println(div);
        //System.out.println(divisor);
        //System.out.println(remainder);
        
        
        remainder=divide(divisor,div,remainder);
        
        for(int i=0;i<remainder.length;i++)
        {
            crc[i]=remainder[i]^divisor[i];
            
        
        }

        for(int i=0;i<remainder.length;i++)
            System.out.print(remainder[i]);
        
        System.out.println("The CRC code is");
        for(int i=0;i<crc.length;i++)
            System.out.print(crc[i]);
        
        
        System.out.println("Enter the CRC code ");
        for(int i=0;i<crc.length;i++)
            crc[i]=sc.nextInt();
        
        for(int i=0;i<crc.length;i++)
            remainder[i]=crc[i];
        
        remainder=divide(crc, div, remainder);
        
        for(int i=0;i<remainder.length;i++)
        {
            if(remainder[i]!=0)
            {
                System.out.println("Error detected");
            }
            if(i==remainder.length-1)
            {
                System.out.println("No error");
            }
        }
        
    }

    private static int[] divide(int[] divisor, int[] div, int[] remainder) {
        
        int count=0;
        
        while(true)
        {
            for(int i=0;i<div.length;i++)
            {
                remainder[count+i]=remainder[count+i]^div[i];
            }
            
            while(remainder[count]==0 && count!=remainder.length-1)
            {
                count++;
            }
            
            if(((remainder.length)-count)<div.length)
                break;
        }
        return remainder;
        
    }
}
