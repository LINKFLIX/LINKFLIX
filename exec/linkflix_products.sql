-- MySQL dump 10.13  Distrib 5.7.33, for Win64 (x86_64)
--
-- Host: localhost    Database: linkflix
-- ------------------------------------------------------
-- Server version	5.7.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `search_keyword` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_pgy9p1o6jsqkwpqy9dusap92s` (`search_keyword`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'2021-11-03 15:12:41.129000','2021-11-03 15:12:41.129000','/product_images/9b1f19fa-9af1-4062-8e56-a902411a8560.jpg','에르메스 Authentic Herm s Rose Azalee Evercolor Calfskin Roulis Handbag - BNIB Authentic Herm s Ros','hermes roulis'),(2,'2021-11-03 15:18:03.125000','2021-11-03 15:18:03.125000','/product_images/3645508c-c533-4729-a98b-988942f1aaca.jpg','로저비비에 실버 여성 플라워 스트라스 버클 펌프스 / ROGER VIVIER FLOWER STRASS BUCKLE PUMPS (관부가세 불포함)','로저비비에 flower strass'),(3,'2021-11-03 15:18:48.664000','2021-11-03 15:18:48.664000','/product_images/c57e74a3-3620-4946-946c-9dce6c5aabe1.jpg','HYERES LOR 에리떼 실버 커브 엠블럼 귀걸이 HL5E13518W9XXX','이에르로르 에리떼'),(4,'2021-11-03 15:19:29.380000','2021-11-03 15:19:29.380000','/product_images/e8757ff5-e22b-4eb8-a58f-625b0a329b71.jpg','까르띠에 PANTHERE 팬더 미니사이즈 스틸밴드 WSPN0019','cartier panthere'),(5,'2021-11-03 15:19:56.000000','2021-11-03 15:19:56.000000','/product_images/02f67ae6-2a3d-47a8-984e-9d6bbed360d8.jpg','에르메스 에르백 31 Herbag Zip 31 Dune Magnolia','hermes herbag zip 31 retourne'),(6,'2021-11-03 15:20:43.535000','2021-11-15 16:36:12.042000','/product_images/6e5cfb1a-3c28-49d2-9d20-14c5545fe33a.jpg','쿠론 Swing Jean Tote 26 RCBTX21115BKX','Swing Jean(스윙 진) Tote 26'),(7,'2021-11-03 15:21:33.730000','2021-11-03 15:21:33.730000','/product_images/6ce84592-aa44-4597-a95d-4c62a51774f6.jpg','로저비비에 Slidy Viv 스웨이드 시어링 슬리퍼','로저비비에 Slidy Viv 스웨이드 시어링 슬리퍼'),(8,'2021-11-03 15:21:52.163000','2021-11-03 15:21:52.163000','/product_images/e3f6d5ba-69c8-4177-bd5b-f325a40ba12e.jpg','이자벨마랑 브라운 스티치장식 소가죽 숄더겸크로스백 ISBA1E004W2','이자벨마랑 브라운 스티치장식 소가죽 숄더겸크로스백'),(9,'2021-11-03 15:22:09.957000','2021-11-15 16:36:38.021000','/product_images/6dc95372-8090-4341-8e24-317d7ec3a2b6.jpg','까르띠에 시계 BALLON BLANC De W4BL2202 W4BL0002','BALLON BLANC DE CARTIER WATCH'),(10,'2021-11-03 15:22:26.016000','2021-11-15 16:36:59.782000','/product_images/2a374c4f-af93-43da-95e0-1e930b16fb9a.jpg','비뮤즈맨션 Linen embroidery cardigan 21SUMBEMU1','비뮤즈맨션 Linen embroidery cardigan'),(11,'2021-11-03 15:22:42.939000','2021-11-15 16:37:34.642000','/product_images/8e25476a-fdc9-424b-a973-4148532e0f95.jpg','쿠론 Ronde 크로스 21 RCBRX21716GRX','쿠론 론드(Ronde) 크로스 21'),(12,'2021-11-03 15:23:00.879000','2021-11-03 15:23:00.879000','/product_images/9ee4b05b-f9eb-49e1-9196-59585c21bede.jpg','로아주 silver925 half pearl hook earring','로아주 half pearl hook earring'),(13,'2021-11-03 15:23:15.477000','2021-11-03 15:23:15.477000','/product_images/02888bdd-f061-4204-bbb5-8815cc96f6b8.jpg','알렉산더맥퀸 더 커브 버킷 크로스백','알렉산더맥퀸 더 커브 버킷 크로스백'),(14,'2021-11-03 15:23:39.266000','2021-11-03 15:23:39.266000','/product_images/f3c7beaf-a460-477d-a299-34525800bd85.jpg','AND YOU HALLA Two pocket shirt Cream','AND YOU HALLA Two pocket shirt Cream'),(15,'2021-11-03 15:23:55.351000','2021-11-15 16:37:59.581000','/product_images/d4479721-082c-4bb6-a087-24f1eb49d3fa.jpg','로저비비에 트레 비비에 버클 벨벳 펌프스','로저비비에 로저 비비에 트레 비비에 버클 벨벳 펌프스'),(16,'2021-11-03 15:24:51.591000','2021-11-03 15:24:51.591000','/product_images/ab10688a-a6f4-4dde-8715-1d5fefbafa41.JPG','지방시 르 루즈 딥 벨벳 N37 루즈 그레네','지방시 르 루즈 딥 벨벳'),(18,'2021-11-03 15:25:29.144000','2021-11-14 16:49:53.583000','/product_images/4d5d182d-b9d6-4340-b525-d04f00fc65b6.JPG','에르메스 에르백 Herbag Zip Retourne Cabine','에르메스 에르백 31'),(19,'2021-11-03 15:25:51.015000','2021-11-03 15:25:51.015000','/product_images/39e875c1-96e0-4d9a-a17e-05f4dbfcaf49.jpg','로렌랄프로렌 인타시아 니트 코튼 모달 여름 반팔 스웨터 YELLOW','인타르시아 니트 코튼-모달 스웨터 비치옐로우'),(20,'2021-11-03 15:26:06.557000','2021-11-03 15:26:06.557000','/product_images/20d94519-c2ad-4cdf-808e-fdbd3ab7c5dc.png','[ASIA] 스트라이프 긴팔 티셔츠 (LIGHT ORANGE) CKTS0F525O1','CKTS0F525O1'),(21,'2021-11-12 09:53:22.982000','2021-11-12 09:53:22.982000','/product_images/0bede442-c216-42dd-9e99-be8a3e8bc4ec.JPG','피자알볼로 팔자피자','피자알볼로 팔자피자'),(22,'2021-11-15 15:57:31.412000','2021-11-15 15:57:31.412000','/product_images/c4becdfc-987e-4c0b-8a70-1ab6234710c1.jpg','막스마라 여성 Zircone wool sweater','MAX MARA Zircone wool sweater'),(23,'2021-11-18 01:41:17.010000','2021-11-18 01:41:17.010000','/product_images/cee90c75-877e-4f1d-b61f-a9a45a5c29f8.jpg','아식스 테니스 양말 남성 장목 스포츠양말','아식스 양말'),(24,'2021-11-18 01:42:14.073000','2021-11-18 01:42:14.073000','/product_images/e9dea33a-ca3e-4e77-bda1-ffb1264c4b04.jpg','LG전자 LG G3 LG-F400S','LG G3폰'),(25,'2021-11-18 01:42:36.990000','2021-11-18 01:42:36.990000','/product_images/86ae67ed-73a8-48fd-9045-c877f56f198f.jpg','새턴바스 세턴바스VESS 베스 액상 레진 직사각 라운드 고급 욕조 SBL-1802','새턴바스 욕조 SBL-1802'),(26,'2021-11-18 01:43:00.137000','2021-11-18 01:43:00.137000','/product_images/17fddb8f-7874-4fa3-9a79-2c0506063295.jpg','오미베리 베리티','오미베리 베리티 325ml'),(27,'2021-11-18 01:43:26.398000','2021-11-18 01:43:26.398000','/product_images/cdd52758-b95c-401c-ac8e-4de43521dee5.jpg','SK매직 DWA-19R0P','SK매직 DWA-19R0P'),(28,'2021-11-18 01:43:58.991000','2021-11-18 01:43:58.991000','/product_images/ab1b59c5-970b-4a7e-980a-2bda8c69c67c.jpg','뱅앤울룹슨 BeoPlay H9i','뱅앤울룹슨 h9i'),(29,'2021-11-18 01:46:01.675000','2021-11-18 01:46:01.675000','/product_images/6abb2174-e227-475f-afad-1dad11f5d944.jpg','농심 올리브 짜파게티','짜파게티'),(30,'2021-11-18 01:46:21.275000','2021-11-18 01:46:21.275000','/product_images/e9fdafbf-2c5e-4e80-816b-5577c5435ad3.jpg','농심 얼큰한 너구리','너구리'),(31,'2021-11-18 01:46:49.561000','2021-11-18 01:46:49.561000','/product_images/e242ff8e-bced-4ffc-9959-decbc579463d.jpg','한우 채끝살','한우 채끝살'),(33,'2021-11-18 11:32:06.670000','2021-11-18 11:32:06.670000','/product_images/0cdd74b9-d8d7-4886-a8d1-a9a0e30756c2.jpg','AND YOU FAIRFAX Puffed shoulder waist tuck detail shirt dress','AND YOU FAIRFAX Puffed shoulder waist tuck detail shirt dress');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-18 22:25:47
