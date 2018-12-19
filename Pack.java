public class Pack extends CardSet {

	public int result = 0;

	private int normal = 0;
	private int rare = 0;
	private int sRare = 0;
	private int ssRare = 0;

	private int normalRate = 0;

	private int sRareRate;
	private int sRarePack;

	private int ssRareRate;
	private int ssRarePack;

	// UnitTest에서 get으로 가져가야함

	private int goldenLegend = 0;

	private int countPack = 0;

	private int unitTest = 0;
	private int unitTestCompare = 0;

	
	public int getGoldenLegend() {
		return goldenLegend;
	}
	public int getCountPack() {
		return countPack;
	}
	public int getUnitTest() {
		return unitTest;
	}
	public int getUnitTestCompare() {
		return unitTestCompare;
	}



	// String[] 안에 넣은 만큼 개봉할 수 있다. (5 : 1)
	String openResult[] = new String[5000];
	UnitTest unit = new UnitTest();

	public void open() {

		rndGen();


		// 1번부터 5장까지 뽑아가는 반복문
	
		// 21 보다 작다면 R (1~20)
		if (getCardRate() < getRareRate() ) {
			openResult[result] = "	희귀 카드 [R]";
			rare ++;

		// 24 보다 작다면 SR (21 ~ 24)
		} else if (getCardRate() <getSRareRate() && getCardRate() >= getRareRate() ) {
			openResult[result] = "	영웅 카드 [SR]";
			sRare ++;
			sRareRate ++;

		// 25면 SSR (25)
		} else if (getCardRate() == getSsRareRate()) {
			openResult[result] = "	전-설 카드 [SSR]";
			ssRare ++;
			ssRareRate ++;

		} else if (getCardRate() > getSsRareRate()) {
			openResult[result] = "	일반 카드";
			normal ++;
			normalRate ++;
		} 

	
	

	}

	// 노말 5장 -> 희귀의 확률 보정.
	// result는 1이 아닌 0부터 시작한다는걸 잘 생각하자.
	public void calibrate() {
		
		if (ssRareRate == 0 && ssRarePack >38) {
			openResult[result] = "	전-설 카드(보정)	[SR]";
			ssRare ++;
			ssRarePack = 0;
			ssRareRate = 0;
		}

		else if (sRareRate == 0 && sRarePack >18) {
			openResult[result] = "	영웅 카드(보정)	[SR]";
			sRare ++;
			sRarePack = 0;
			sRareRate = 0;

		}

		else if (normalRate > 4) {
			openResult[result] = "	희귀 카드(보정) [R]";	
			rare ++;
		} 
	

		if (getCardRate() > getGoldenRate()) {
			openResult[result] = "황금" + openResult[result];

		}
	
	}


	public void openResult() {
		
		System.out.println("[" + (countPack + 1) + " 팩]");
		countPack ++;

		// 1팩 (5장 개봉)
		for (int i = 0; i<5; i++) {
			open();
			calibrate();
			System.out.println(openResult[result]);
			result ++;
			unit.UnitTestExcess();
		}

		sRarePack ++;
		ssRarePack ++;
		normalRate = 0;

	}


	public void totalResult() {
		System.out.println("전설 카드 : " + ssRare + "장");
		System.out.println("영웅 카드 : " + sRare+ "장");
		System.out.println("희귀 카드 : " + rare+ "장");
		System.out.println("일반 카드 : " + normal+ "장");
		if (goldenLegend > 1) {
			System.out.println("	황금 전설 카드 : " + goldenLegend + "장");
		}
	}

	public int caclulateDust() {
		int dust = ssRare * 400 + sRare * 100 + rare * 20 + normal * 5;
		System.out.println("가루 : " + dust);
		return dust;

	}

	
}