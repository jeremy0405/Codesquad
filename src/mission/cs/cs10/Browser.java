package mission.cs.cs10;

public class Browser {

	public static void main(String[] args) {
		RequestApp requestGoogle = new RequestApp("http://www.google.co.kr");


		RequestApp requestGoogleQuery = new RequestApp("www.google.co.kr/search?q=%EC%BD%94%EB%93%9C%EC%8A%A4%EC%BF%BC%EB%93%9C&ei=rRYFYtzRI4j70gTq9qXYAw&ved=0ahUKEwic3KiqovX1AhWIvZQKHWp7CTsQ4dUDCA4&uact=5&oq=%EC%BD%94%EB%93%9C%EC%8A%A4%EC%BF%BC%EB%93%9C&gs_lcp=Cgdnd3Mtd2l6EAMyCwguEIAEEMcBEK8BMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEOgsIABCABBCxAxCDAToICAAQgAQQsQM6DgguEIAEELEDEMcBEKMCOggILhCABBCxAzoOCC4QgAQQsQMQxwEQrwFKBAhBGABKBAhGGABQAFj5BmCDDGgCcAF4BIAByAGIAbwOkgEGMi4xMC4xmAEAoAEBwAEB&sclient=gws-wiz");


	}

}
