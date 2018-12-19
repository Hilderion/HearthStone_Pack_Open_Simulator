import java.util.Random;

public class CardSet {

	Random rnd = new Random();

	public void rndGen() {
		
		cardRate = (rnd.nextInt(100))+1;

		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private int cardRate = 0;

	private final int cardNumber = 5;

	private final Double rareRate = 21.0;
	// 1���� 20������ R
	private final Double sRareRate = 25.0;
	// 21���� 24������ SR
	private final Double ssRareRate = 25.0;
	// 25�� SSR
	// 26 ~ 100 ������ �˴� N

	private final Double goldenRate = 95.0;
	// 95 ~ 100���� ����� ���� ������ Ȳ�� ī�尡 ��

	public int getCardNumber() {
		return cardNumber;
	}

	public Double getRareRate() {
		return rareRate;
	}

	public Double getSRareRate() {
		return sRareRate;
	}

	public Double getSsRareRate() {
		return ssRareRate;
	}

	public Double getGoldenRate() {
		return goldenRate;
	}

	public int getCardRate() {
		return cardRate;
	}

}