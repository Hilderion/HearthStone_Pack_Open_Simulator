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

	// UnitTest���� get���� ����������

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



	// String[] �ȿ� ���� ��ŭ ������ �� �ִ�. (5 : 1)
	String openResult[] = new String[5000];
	UnitTest unit = new UnitTest();

	public void open() {

		rndGen();


		// 1������ 5����� �̾ư��� �ݺ���
	
		// 21 ���� �۴ٸ� R (1~20)
		if (getCardRate() < getRareRate() ) {
			openResult[result] = "	��� ī�� [R]";
			rare ++;

		// 24 ���� �۴ٸ� SR (21 ~ 24)
		} else if (getCardRate() <getSRareRate() && getCardRate() >= getRareRate() ) {
			openResult[result] = "	���� ī�� [SR]";
			sRare ++;
			sRareRate ++;

		// 25�� SSR (25)
		} else if (getCardRate() == getSsRareRate()) {
			openResult[result] = "	��-�� ī�� [SSR]";
			ssRare ++;
			ssRareRate ++;

		} else if (getCardRate() > getSsRareRate()) {
			openResult[result] = "	�Ϲ� ī��";
			normal ++;
			normalRate ++;
		} 

	
	

	}

	// �븻 5�� -> ����� Ȯ�� ����.
	// result�� 1�� �ƴ� 0���� �����Ѵٴ°� �� ��������.
	public void calibrate() {
		
		if (ssRareRate == 0 && ssRarePack >38) {
			openResult[result] = "	��-�� ī��(����)	[SR]";
			ssRare ++;
			ssRarePack = 0;
			ssRareRate = 0;
		}

		else if (sRareRate == 0 && sRarePack >18) {
			openResult[result] = "	���� ī��(����)	[SR]";
			sRare ++;
			sRarePack = 0;
			sRareRate = 0;

		}

		else if (normalRate > 4) {
			openResult[result] = "	��� ī��(����) [R]";	
			rare ++;
		} 
	

		if (getCardRate() > getGoldenRate()) {
			openResult[result] = "Ȳ��" + openResult[result];

		}
	
	}


	public void openResult() {
		
		System.out.println("[" + (countPack + 1) + " ��]");
		countPack ++;

		// 1�� (5�� ����)
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
		System.out.println("���� ī�� : " + ssRare + "��");
		System.out.println("���� ī�� : " + sRare+ "��");
		System.out.println("��� ī�� : " + rare+ "��");
		System.out.println("�Ϲ� ī�� : " + normal+ "��");
		if (goldenLegend > 1) {
			System.out.println("	Ȳ�� ���� ī�� : " + goldenLegend + "��");
		}
	}

	public int caclulateDust() {
		int dust = ssRare * 400 + sRare * 100 + rare * 20 + normal * 5;
		System.out.println("���� : " + dust);
		return dust;

	}

	
}