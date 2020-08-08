package tddbc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CloseRangeTest {

	CloseRange closeRange_3_8 = new CloseRange(3, 8);

	@Nested
	class 整数閉区間は文字列表現を返せる {
		@Test
		@DisplayName("下端点3,上端点 8 の整数閉区間の文字列表記は[3,8]")
		public void 下端点3上端点8の整数閉区間の文字列表記() {
			assertThat(closeRange_3_8.display(), is("[3,8]"));
		}
	}

	@Nested
	class 上端点より下端点が大きい整数閉区間を作ることはできない {
		@Test
		public void 下端点8上端点3の整数閉区間は生成できない() {
			assertThrows(IllegalArgumentException.class, () -> new CloseRange(8, 3));
		}

		@Test
		public void 下端点3上端点3の整数閉区間は生成できる() {
			new CloseRange(3, 3);
		}
	}

	@Nested
	class 整数閉区間は指定した整数を含むかどうかを判定できる {
		@Test
		public void 下端点3上端点8の整数閉区間に8が含まれる() {
			assertThat(closeRange_3_8.include(8), is(true));
		}

		@Test
		public void 下端点3上端点8の整数閉区間に9が含まれない() {
			assertThat(closeRange_3_8.include(9), is(false));
		}

		@Test
		public void 下端点3上端点8の整数閉区間に3が含まれる() {
			assertThat(closeRange_3_8.include(3), is(true));
		}

		@Test
		public void 下端点3上端点8の整数閉区間に2が含まれない() {
			assertThat(closeRange_3_8.include(2), is(false));
		}
	}

	@Nested
	class 別の整数閉区間と等価かどうかを判定できる {
		@Test
		public void 下端点3上端点8の整数閉区間と下端点3上端点8の整数閉区間が等価であると判定できる() {
			CloseRange anotherCloseRange = new CloseRange(3, 8);
			assertThat(closeRange_3_8.equals(anotherCloseRange), is(true));
		}

		@Test
		public void 下端点3上端点8の整数閉区間と下端点2上端点9の整数閉区間が等価であると判定できる() {
			CloseRange anotherCloseRange = new CloseRange(2, 9);
			assertThat(closeRange_3_8.equals(anotherCloseRange), is(false));
		}
	}

	@Nested
	class 別の整数閉区間に完全に含まれるかどうかも判定できる {
		@Test
		public void 下端点3上端点8の整数閉区間に下端点3上端点9の整数閉区間が完全に含まれない() {
			CloseRange anotherCloseRange = new CloseRange(3, 9);
			assertThat(closeRange_3_8.contains(anotherCloseRange), is(false));
		}

		@Test
		public void 下端点3上端点8の整数閉区間に下端点2上端点8の整数閉区間が完全に含まれない() {
			CloseRange anotherCloseRange = new CloseRange(2, 8);
			assertThat(closeRange_3_8.contains(anotherCloseRange), is(false));
		}

		@Test
		public void 下端点3上端点8の整数閉区間に下端点3上端点8の整数閉区間が完全に含まれる() {
			CloseRange anotherCloseRange = new CloseRange(3, 8);
			assertThat(closeRange_3_8.contains(anotherCloseRange), is(true));
		}

		@Test
		public void 下端点3上端点8の整数閉区間に下端点4上端点7の整数閉区間が完全に含まれる() {
			CloseRange anotherCloseRange = new CloseRange(4, 7);
			assertThat(closeRange_3_8.contains(anotherCloseRange), is(true));
		}
	}
}
