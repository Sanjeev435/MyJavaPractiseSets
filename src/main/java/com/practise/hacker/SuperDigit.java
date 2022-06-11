package com.practise.hacker;

/**
 * @author Sanjeev Kumar
 * 
 *         </br>
 *         </br>
 *         <b>Problem Type : Algorithm -> Recursion</b> </br>
 *         <b>Problem Difficulty : Medium</b></br>
 * @see <a href=
 *      "https://www.hackerrank.com/challenges/recursive-digit-sum/problem">
 *      Recursive Digit Sum </a>
 *
 */
public class SuperDigit {

	public static void main(String[] args) {
		System.out.println(superDigit("9875", 4)); // 8
		System.out.println(superDigit("148", 3)); // 3
		System.out.println(superDigit("148", 3)); // 3

		String s = "740495400969422744624637574722785221369257089071788417400158753714583872339036262448792613116111271058912742309"
				+ "89593270205440033957924826251917216033283077749981243896410698846340868491385150792207504623173574877627804805766"
				+ "406891753469561356684518354804900899624067732675696506639277788677643152112806250333882715182649610901115474804670"
				+ "6522984361387349984639025737593304008686343052366805004693038701389706210630940687442500112789057498661001809385969"
				+ "34555184132689143618590006149044619024428225775529976800983891830826546250988174113069850106587567621521609042781694"
				+ "916348074643561308775263927254320864399340067289144110618612353009795361901007343606840545574484546407501984668771858"
				+ "752900111146671867304526819430439718123806281175271723898895457767795556648264885203252347926484486252253645350536055"
				+ "153867309250700728960046454167136820046006365743890406628271826963371876109046940292218808013728640403455672309411109"
				+ "86028568372710970460116491983700312243090679537497139499778923997433720159174153";
		System.out.println(superDigit(s, 100000)); // 3
	}

	public static int superDigit(String n, int k) {
		if (n.length() == 1) {
			return Integer.parseInt(n);
		}
		return getSuperDigit(n, k, false).intValue();
	}

	private static Long getSuperDigit(String data, int k, boolean multiplied) {

		if (data.length() == 1) {
			if (multiplied) {
				return Long.parseLong(data);
			} else {
				multiplied = true;
				data = String.valueOf(Long.parseLong(data) * k);
			}
		}

		long sum = 0;
		for (String s : data.split("")) {
			sum += Long.parseLong(s);
		}

		sum = getSuperDigit(String.valueOf(sum), k, multiplied);

		return sum;
	}

}
