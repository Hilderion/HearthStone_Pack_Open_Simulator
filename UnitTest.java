public class UnitTest extends Pack {
		
	private int goldenLegend = getGoldenLegend() ;

	private int countPack = getCountPack();

	private int unitTest = getUnitTest();
	private int unitTestCompare = getUnitTestCompare();
	

	public void UnitTestExcess() {
	
		// Ȳ�� ��-�� ī�� [SSR] ��ġ
		String getGold = "Ȳ��	��-�� ī�� [SSR]";
		if (openResult[result].equals(getGold)) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			goldenLegend ++;
		}

		// TODO : ���� ���ڿ��� �־ .equals()�� �� ���� �ִ�.
		// TODO : �񱳴���� ������ ������ .equals()�� ���� �� �� -> null ���� ���
		// "Ȳ��	��-�� ī�� [SSR]".equals(openResult[result]);

		// �����׽�Ʈ (���) 
		String getRare = "Ȳ��	��� ī�� [R]";
		String getRare2 = "Ȳ��	��� ī��(����) [R]";
		if (openResult[result].equals(getRare) || openResult[result].equals(getRare2)) {
			System.out.print("		<!>");
			unitTest ++;
			unitTestCompare = countPack;

		} 
	
	}

	public void unitTestResult() {
		System.out.println("======");

		if (unitTest > 0) {
			System.out.println ("���� �׽�Ʈ�� �߻��� �� : " + unitTestCompare);
		} else {
			System.out.println("���� �׽�Ʈ �߻� ��� ����.");
		} 

	}

	

}