package com.video.show.service;

import java.util.List;

import com.entity.tb_shiping;
import com.entity.tb_type;

public interface showVideoService {

	List<tb_shiping> findAddVideo();

	List<tb_shiping> findRecommendVideo();//�ҵ��Ƽ���Ƶ

	List<tb_shiping> findFreeVideo();//�ҵ������Ƶ

	int findIdByName(String name); //ͨ�������ҵ�id

	int insertComment(int id, int shibian, String text);//���۹���

	List<tb_shiping> findVideoByTid(int a1);//����tid�ҵ���Ƶ

	List<tb_type> findTypeBytid(int i);//����tid�ҵ�type������
}
