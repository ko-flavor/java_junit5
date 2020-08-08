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
		return String.format("[%d,%d]", lowerEndpoint, upperEndpoint);
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
			return identify(anotherCloseRange);
		}
		return false;
	}

	public boolean identify(CloseRange another){
		return another.display().equals(this.display());
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + lowerEndpoint;
		result = 31 * result + upperEndpoint;
		return result;
	}

	public boolean contains(CloseRange anotherCloseRange) {
		return this.lowerEndpoint <= anotherCloseRange.lowerEndpoint
				&& anotherCloseRange.upperEndpoint <= this.upperEndpoint;
	}

}
