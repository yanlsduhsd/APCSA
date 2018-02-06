//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

public class Fahrenheit
{
	private double fahrenheit;

	public void setFahrenheit(double fahren)
	{
		fahrenheit=fahren;
	}

	public double getCelsius()
	{
		double celsius = 0.0;
		celsius=(fahrenheit-32)*(5/9.0);
		return celsius;
	}

	public void print()
	{
		//this is part of the solution
		System.out.println(String.format("%.2f degrees Fahrenheit == %.2f degrees Celsius", fahrenheit, getCelsius()));
	}
}