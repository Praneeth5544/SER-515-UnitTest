package org.example;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class urinals {
    public boolean goodString(String str)
    {
        Boolean b=false;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='1'||str.charAt(i)=='0') {
                b = true;
            }
            else {
                b=false;
                break;
            }
        }
        return b;
    }
    public int countUrinals(String str)
    {
        if(goodString(str))
        {
            char[] arr = new char[str.length()];
            int c2=0;
            for (int i = 0; i < str.length(); i++)
            {
                arr[i] = str.charAt(i);
            }
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
                if((i+1)<arr.length)
                {
                    if(arr[i]=='1' && arr[i+1]=='1')
                    {
                        //System.out.println("Not possible");
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
                                //System.out.println("Vacancy at "+ (i+2));
                                c2=c2+1;

                            };
                        }
                        else if((i+2)<arr.length)
                        {
                            if(arr[i+2]=='0')
                            {
                                arr[i+2]='1';
                                //System.out.println("Vacancy at "+ (i+2));
                                c2=c2+1;

                            };
                        }
                    }
                }

            }
            //System.out.println(arr);
            return c2;
        }
        else {
            return -1;
        }
    }
    public int openFile()
    {
        int i = 0,j=0;
        try {
            FileReader fr = new FileReader("C:\\Users\\hp\\Desktop\\SER 515\\Assignment-2-Ind\\SER-515-Praneeth-Reddy-K\\TextFiles\\BuyerInfo.txt");
            FileWriter fWriter = new FileWriter("C:\\Users\\hp\\Desktop\\SER 515\\Assignment-2-Ind\\SER-515-Praneeth-Reddy-K\\javafiles\\SER-515-UnitTest\\rule1.txt");
            //File f=new File();
            BufferedReader br = new BufferedReader(fr);
            BufferedWriter bw= new BufferedWriter(fWriter);
            String st;
            while ((st = br.readLine()) != null) {
                StringTokenizer s = new StringTokenizer(st, " ");
                while (s.hasMoreTokens())
                {
                    i=countUrinals(s.nextToken());
                    bw.write(i);
                    bw.newLine();
                }
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("File created Successfully");
        return i;
    }
    public static void main(String[] args) throws Exception
    {
        urinals u= new urinals();
        Scanner sc = new Scanner(System.in);
        System.out.println("For Input from keyboard enter 0 For Input from files enter 1");
        int opt=sc.nextInt();
        if(opt==0) {
            System.out.println("Enter The string");
            String str = sc.next();
            int x = u.countUrinals(str);
            System.out.println(x);
        }
        else {
            int z=u.openFile();
            System.out.println(z);
        }
    }
}
