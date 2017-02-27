//Problem 46:
//It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.

import java.util.ArrayList;
import java.lang.Math;

//9 = 7 + 2×12
//15 = 7 + 2×22
//21 = 3 + 2×32
//25 = 7 + 2×32
//27 = 19 + 2×22
//33 = 31 + 2×12

//It turns out that the conjecture was false.

//What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
		
public class GoldbachConjecture {
	
	static ArrayList<Integer> primes;
	
	public static void main(String args[]){
		
		primes=new ArrayList<Integer>();
		
		for(int i=1;i<100000;i++){
			
			boolean isComposite=false;
			//only check odd composites
			if(i%2==1){
				
				for(int n=2;n<i;n++){
					if(i%n==0){
						isComposite=true;
					}
				}
				if(!isComposite){
					primes.add(i);
				}
				else if(!isGoldbach(i)){
						System.out.println(i);
						break;
				}
			}
		}
				
	}
	
	public static boolean isGoldbach(int num){
		
		int k=0;
		while(k<primes.size()){
			int sum=num-primes.get(k);
			if(sum<0){
				break;
			}
			else{
				int mod=(int)Math.sqrt(sum/2);
				if(Math.pow(mod, 2)==(sum/2)){
					return true;
				}
			}
			k++;
		}
		
		return false;
	}

}
