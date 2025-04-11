package pack.controller;

import pack.model.DataDao;

public class SelectServiceImpl implements SelectService{
	private DataDao dataDao;
	
	public SelectServiceImpl(DataDao dataDao) {	// 생성자 주입
		System.out.println("SelectServiceImpl 생성자");
		// 생성자를 이용해 dataDao에게 주소 치환
		this.dataDao = dataDao;
	}
	
	@Override
	public void selectProcess() {
		System.out.println("컨트롤러 영역의 selectProcess 실행");
		dataDao.selectData();
	}
}
