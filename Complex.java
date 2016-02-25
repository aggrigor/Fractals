class Complex
{
	private final double re;   
	private final double im;   

	
	public Complex(double real, double imag)
	{
		re = real;
		im = imag;
	}

	
	public String toString()
	{
		if (im == 0) return re + "";
		if (re == 0) return im + "i";
		if (im <  0) return re + " - " + (-im) + "i";
		return re + " + " + im + "i";
	}


	public double abs()   { return Math.hypot(re, im); }  //upologismos metrou
	public double phase() { return Math.atan2(im, re); }  //upologismos theta

	

	public Complex plus(Complex b)				//prosthesi migadikon
	{
		Complex a = this;             
		double real = a.re + b.re;
		double imag = a.im + b.im;
		return new Complex(real, imag);
	}


	public Complex minus(Complex b)				//afairesi migadikon
	{
		Complex a = this;
		double real = a.re - b.re;
		double imag = a.im - b.im;
		return new Complex(real, imag);
	}

	
	public Complex times(Complex b)				//pollaplasiasmos migadikon
	{
		Complex a = this;
		double real = a.re * b.re - a.im * b.im;
		double imag = a.re * b.im + a.im * b.re;
		return new Complex(real, imag);
	}

	
		
	public Complex times(double alpha)			//klimakotos pollaplasiasmos
	{
		return new Complex(alpha * re, alpha * im);
	}

	
	public Complex conjugate() {  return new Complex(re, -im); }	//return tin klisi

	
	public Complex reciprocal()					//suzigis
	{
		double scale = re*re + im*im;
		return new Complex(re / scale, -im / scale);
	}

	
	public double re() { return re; }
	public double im() { return im; }

	
	public Complex divides(Complex b)			//diairesi migadikon
	{
        	Complex a = this;
		return a.times(b.reciprocal());
	}

	
	public Complex exp()					//ekthetikos
	{
		return new Complex(Math.exp(re) * Math.cos(im), Math.exp(re) * Math.sin(im));
	}

	
	public Complex sin()					//imitono
	{
		return new Complex(Math.sin(re) * Math.cosh(im), Math.cos(re) * Math.sinh(im));
    	}

	
	public Complex cos()					//sunimitono
	{
		return new Complex(Math.cos(re) * Math.cosh(im), -Math.sin(re) * Math.sinh(im));
	}

	
	public Complex tan()					//efaptomeni
	{
		return sin().divides(cos());
	}

    	
	public static Complex plus(Complex a, Complex b)         //static athroisma
	{
		double real = a.re + b.re;
		double imag = a.im + b.im;
		Complex sum = new Complex(real, imag);
		return sum;
	}
}