/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathfinder;
import java.util.Scanner;
/**
 *
 * @author manan
 */
class inp{
int sum=0,m=0,n=0;
int[][] arr;
Scanner s= new Scanner(System.in);

int small,max;
//String smp="",ps="", sp="";

public int[][] getarr(){
         //this function is used to input the contents in array
    System.out.println("enter no. of rows and columns");
    m=s.nextInt();
    n=s.nextInt();
    arr= new int[m][n];
    for(int i=0; i<m; i++){
        for(int j=0; j<n; j++)
           {
               arr[i][j] = s.nextInt();
           }   
    }
   return arr;
  }
    
    public int path(int[][] arr,int sum,int a,int b){
        //this function returns the value of smallest path sum
        
        //System.out.println("start-["+a+"]["+b+"]");
        
        if(arr[a][b]>=0){                    
        if((a>=m-1)&&(b>=n-1))
        {            
             //suucessfully reached end
             //System.out.println("end sum="+sum);
             
             if(sum<small)
             {
                 small=sum;
             }
                             
             return small;
        } 
        else if((a>=m-1)&&(b<n-1)){    
            //only down possible
             return path(arr,sum+ arr[a][b+1],a,b+1);                
        }
        else if((b>=n-1)&&(a<m-1)){
            // only right possible
             return path(arr,sum+ arr[a+1][b],a+1,b);                
        }
        else
        {
           // both right and down possible
            
            //System.out.println("path divided into 2");            
            int right= path(arr,sum +arr[a+1][b],a+1,b);
            int down= path(arr,sum+ arr[a][b+1],a,b+1);
            if(right<down)
            {return right;}
            else
            {return down;}
        }
        }
        else{
            //System.out.println("this path is not possible");
            return max+1;
        }
    }
    
    public int patha(int[][] arr,int sum,int a,int b){
        // this function takes out a max value(no path length can exceed this value)
    //System.out.println("patha");
    max=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++)
             {
                 if(arr[i][j] > 0)
                 {
                     max=max+arr[i][j];
                 }                 
            }                       
        }
        small=max;
        
     small= path(arr,sum,a,b);
    return small;
    }
    
    
        public void disparr(){
            //to display arr if needed
            System.out.println("after input- ");
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++)
             {
                 System.out.print(" "+arr[i][j]);
            }   
            System.out.println();        
        }
    } 
    
}
public class Pathfinder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] arr= null;
        inp o= new inp();
        arr=o.getarr();
        
       System.out.print("Shortest path sum = "+o.patha(arr,0,0,0));
       
    }
    
}
