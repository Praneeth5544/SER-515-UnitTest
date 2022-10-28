import java.util.Scanner;

public class urinals {
    public int getUrinals(String str)
    {
    char[] arr = new char[str.length()];
        int c2=0;
    //Copy character by character into array
    for (int i = 0; i < str.length(); i++) 
    {
      arr[i] = str.charAt(i);
    }
    //System.out.println(arr);
    for(int i=0 ; i<arr.length;i++)
    {
        if(i==0)
        {
            if(arr[i]=='0'&& arr[i+1]=='0')
            {
                arr[i]='1';
                c2=c2+1;
            }
        }
        //System.out.println(arr[i]);
        if((i+1)<arr.length)
        {
        if(arr[i]=='1' && arr[i+1]=='1')
        {
            System.out.println("Not possible");
            c2 =-1;
            break;
        }
        }
        if(i+1<arr.length)
        {
        if(arr[i]=='1' && arr[i+1]=='0')
        {
            if((i+3)<arr.length)
            {
                if(arr[i+2]=='0'&& arr[i+3]!='1')
                {
                    arr[i+2]='1';
                    System.out.println("Vacancy at "+ (i+2));
                    c2=c2+1;

                };
            }
            else if((i+2)<arr.length)
            {
                if(arr[i+2]=='0')
                {
                    arr[i+2]='1';
                    System.out.println("Vacancy at "+ (i+2));
                    //System.out.println("array position" + i +" changed to " + arr[i+2]);
                    c2=c2+1;

                };
            }
        }
        }

    }
        System.out.println(arr);
        //System.out.print(c2);
        return c2;
    }
    public static void main(String[] args) throws Exception 
    {
        urinals u= new urinals();
    
      Scanner sc = new Scanner(System.in);
       System.out.println("Enter The string");
       String str= sc.nextLine();
    int x= u.getUrinals(str);
    System.out.println(x);
    }
    }