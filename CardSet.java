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
	// 1부터 20까지는 R
	private final Double sRareRate = 25.0;
	// 21부터 24까지는 SR
	private final Double ssRareRate = 25.0;
	// 25는 SSR
	// 26 ~ 100 까지는 죄다 N

	private final Double goldenRate = 95.0;
	// 95 ~ 100까지 경우의 수가 나오면 황금 카드가 됨

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