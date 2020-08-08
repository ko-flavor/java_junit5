package tddbc;

public class CloseRange {

	private final int lowerEndpoint;
	private final int upperEndpoint;

	public CloseRange(int lowerEndpoint, int upperEndpoint) {
		if ((lowerEndpoint <= upperEndpoint) == false) {
			throw new IllegalArgumentException();
		}
		this.lowerEndpoint = lowerEndpoint;
		this.upperEndpoint = upperEndpoint;
	}

	public String display() {
		return "[" + lowerEndpoint + "," + upperEndpoint + "]";
	}

	public boolean include(int number) {
		return this.lowerEndpoint <= number && number <= this.upperEndpoint;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof CloseRange) {
			CloseRange anotherCloseRange = (CloseRange) obj;
			return anotherCloseRange.display().equals(this.display());
		}
		return false;
	}

	public boolean contains(CloseRange anotherCloseRange) {
		return this.lowerEndpoint <= anotherCloseRange.lowerEndpoint
				&& anotherCloseRange.upperEndpoint <= this.upperEndpoint;
	}

}
