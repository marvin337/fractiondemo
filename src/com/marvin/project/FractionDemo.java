package com.marvin.project; 

import java.io.BufferedReader;
import java.io.File; 
import java.io.FileReader; 

import org.apache.commons.lang.math.Fraction;

public class FractionDemo {

	public static void main(String[] args) throws Exception 
	{ 
		if (args == null || args.length != 1)
		{
			System.err.println("Expecting a parameter with directory path. Eg. C://tmp/ ");
			return;
		}
		File dir = new File(args[0]);
		if (!dir.exists())
		{
			System.err.println("Directory '" + dir + "' not found!");
			return;
		}
			
		runTest(dir);
	} 
	
	public static void runTest(File dir) throws Exception
	{	
		File[] files = dir.listFiles();
		if (files.length > 0)
		{
			for(File file : files)
			{
				String[] fractions = readFractionsFromFile(file); 
				Fraction lhs = Fraction.getFraction(fractions[0]);
				Fraction rhs = Fraction.getFraction(fractions[1]);
		
				String lhs1 = getProperOutput(lhs);
				String rhs1 = getProperOutput(rhs);  
				System.out.println("File=" + file);
				outputFractionsSum(lhs, rhs, lhs1, rhs1);
				outputFractionsDifference(lhs, rhs, lhs1, rhs1); 
				outputFractionsProduct(lhs, rhs, lhs1, rhs1);  
				outputFractionsQuotient(lhs, rhs, lhs1, rhs1);
				System.out.println();
			}
		}
	}

	private static String[] readFractionsFromFile(File file) throws Exception
	{ 
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = br.readLine();
		br.close();
		String[] fractions = line.split("\\s+");
		if (fractions.length != 2)
			throw new Exception("Input file " + file 
					+ "does not match format of two rational numbers.");
		return fractions;
	}

	protected static void outputFractionsSum(Fraction lhs, Fraction rhs,
			String lhs1, String rhs1)
	{
		Fraction answer = lhs.add(rhs);     // add two fractions
		System.out.println(lhs1 + " + " + rhs1 + " = " + getProperOutput(answer) );
	}

	protected static void outputFractionsDifference(Fraction lhs, Fraction rhs,
			String lhs1, String rhs1)
	{
		Fraction answer;
		answer = lhs.subtract(rhs); // subtract two fractions
		System.out.println(lhs1 + " - " + rhs1 + " = " + getProperOutput(answer) );
	}
	
	protected static void outputFractionsProduct(Fraction lhs, Fraction rhs,
			String lhs1, String rhs1)
	{
		Fraction answer;
		answer = lhs.multiplyBy(rhs);         // multiplied value  
		if (answer.getNumerator()==0)
		{
			int denominator = lhs.getDenominator() * rhs.getDenominator();
			System.out.println(lhs1 + " * " + rhs1 + " = 0/" + denominator ); 
		}
		else
		System.out.println(lhs1 + " * " + rhs1 + " = " + getProperOutput(answer) );
	}
	
	protected static void outputFractionsQuotient(Fraction lhs, Fraction rhs,
			String lhs1, String rhs1)
	{
		Fraction answer;
		try
		{
			answer = lhs.divideBy(rhs);         // division value 
			System.out.println(lhs1 + " / " + rhs1 + " = " + getProperOutput(answer) ); 
		} catch (Exception e)
		{
			System.out.println("Inf");
		}
	}
	
	private static String getProperOutput(Fraction fraction)
	{ 
		String formatted = fraction.reduce().toProperString();
		if (fraction.getNumerator()==0)
			formatted = fraction.toString();
		if (fraction.abs().compareTo(fraction) != 0)
			formatted = "(" + formatted + ")";
		return formatted; 
	}
}
