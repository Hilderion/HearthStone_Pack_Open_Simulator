public class UnitTest extends Pack {
		
	private int goldenLegend = getGoldenLegend() ;

	private int countPack = getCountPack();

	private int unitTest = getUnitTest();
	private int unitTestCompare = getUnitTestCompare();
	

	public void UnitTestExcess() {
	
		// 황금 전-설 카드 [SSR] 서치
		String getGold = "황금	전-설 카드 [SSR]";
		if (openResult[result].equals(getGold)) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			goldenLegend ++;
		}

		// TODO : 직접 문자열을 넣어서 .equals()를 쓸 수도 있다.
		// TODO : 비교대상이 앞으로 오도록 .equals()를 수정 할 것 -> null 에러 대비
		// "황금	전-설 카드 [SSR]".equals(openResult[result]);

		// 단위테스트 (희귀) 
		String getRare = "황금	희귀 카드 [R]";
		String getRare2 = "황금	희귀 카드(보정) [R]";
		if (openResult[result].equals(getRare) || openResult[result].equals(getRare2)) {
			System.out.print("		<!>");
			unitTest ++;
			unitTestCompare = countPack;

		} 
	
	}

	public void unitTestResult() {
		System.out.println("======");

		if (unitTest > 0) {
			System.out.println ("유닛 테스트가 발생한 팩 : " + unitTestCompare);
		} else {
			System.out.println("유닛 테스트 발생 결과 없음.");
		} 

	}

	

}