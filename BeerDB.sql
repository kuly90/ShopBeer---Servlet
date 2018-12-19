create database BeerDB;
use BeerDB
drop database BeerDB

create table Beers(
	beerID varchar(10),
	beerName varchar(225) not null,
	detail varchar(50),
	quantityInStore int not null,
	price money not null,
	brandID varchar(10) not null,
	image varchar(100),
	dateJoin datetime,
	information nvarchar(2000),
	Constraint PK_Beers primary key Clustered(beerID ASC)
);

create table Promotions(
	beerID varchar(10),
	promotionID varchar(10),
	discount money,
	dateStart date,
	dateEnd date,
	Constraint PK_Promotions primary key Clustered(promotionID ASC)
);

CREATE table Brands(
	brandID varchar(10),
	brandName varchar(50),
	Constraint PK_Brand primary key Clustered(brandID ASC)
);

create table Orderdetails(
	orderDetailID int identity,
	beerID varchar(10),
	quantity int,
	price money,
	discount money,
	orderID int,
	Constraint PK_Orderdetails primary key Clustered(orderDetailID ASC)
);

create table Orders (
	orderID int identity,
	orderDate date,
	custName varchar(50),
	custEmail varchar(50),
	custPhone varchar (15),
	custAddress varchar(50),
	status varchar(50),
	Constraint PK_Orders primary key Clustered(orderID ASC)
);
insert into Orders values
('2011-11-01','Dung','Dung@gmail.com','0905','DaNang','delivered'),	
('2012-12-02','Duc','Duc@gmail.com','0915','DongNai','delivered'),
('2013-01-03','Ly','Ly@gmail.com','0925','MyKhe','delivered'),
('2014-02-04','Vy','Vy@gmail.com','0935','Hue','delivered')

insert into Orderdetails values
('HD01',20,50,9,1),
('HD02',30,60,5,2),
('HNK01',10,100,8,3),
('HNK02',30,200,0,4)

--Insert into table

Insert into Beers values
('HD01','Huda','4%',50,50,'BH','images/HudaBeer.jpg','2011-01-01',N'• HUDA BEER: Là loại bia dòng chính, bia HUDA luôn luôn được khách hàng trong và ngoài nước yêu mến và ủng hộ,
																	 chiếm vị trí hàng đầu tại các tỉnh miền Trung. Bia HUDA được sản xuất ngay những ngày đầu tiên thành lập nhà máy bia Huế. 
																	 Hiện nay Bia HUDA đã có những chủng loại khác nhau nhằm phục vụ ngày càng tốt hơn nhu cầu của người tiêu dùng: 
																	 Bia HUDA chai 45cl, Bia HUDA lon 33cl, Bia HUDA chai 35,5cl, Bia tươi HUDA, Bia hơi HUDA.'),
('HD02','Huda-Gold','4.5%',60,60,'BH','images/HudaGold.png','2014-12-12',N'• Huda Gold - Tự hào đãi bạn
																			Huda Gold được nấu từ loại hoa bia đặc biệt tạo nên hương vị đặc trưng và kết hợp hoàn hảo với các món ăn cay nồng của ẩm thực miền Trung.
																			Thương hiệu đã được quốc tế công nhận và đã được trao huy chương Bạc Vô Địch Bia Thế Giới vào năm 2013.
																			 Huda Gold đã vinh dự đạt giải thưởng Chất Lượng Vượt Trội do Viện nghiên cứu chất lượng quốc tế (ITQI) tại Bỉ trao tặng trong bốn năm 2014, 2015, 2016, 2017 liên tiếp.
																			'),
('TG01','Tiger Crystal','5%',40,80,'BVN1','images/tigerBac.jpg','2013-03-01',N'• Tiger Crystal là dòng bia mới của Tiger Beer. 
																				Điểm độc đáo của bia Tiger Crystal là được sản xuất theo quy trình Cold Suspension. 
																				Từng dòng bia được tinh lọc với kỹ thuật làm lạnh sâu đến -1C (Crystal Cold), hoa bia được tinh chế đặc biệt giúp lưu giữ trọn vẹn hương vị tuyệt hảo của bia.
																				 Nhờ vậy, Tiger Crystal không chỉ đạt đến chất lượng hàng đầu thế giới như truyền thống của Tiger Beer mà còn mang đến cảm giác thật sảng khoái và rất dễ uống.'),
('TG02','Tiger-Brow','4.5%',35,60,'BVN1','images/tigerNau.jpg','2012-04-06',N'• Tiger-Brow - Nguyên liệu sử dụng để tạo ra dòng Bia Tiger bắt đầu từ những thành phần tự nhiên, chọn lọc,
																				 nhập khẩu từ nhà cung cấp đã được chứng nhận chất lượng quốc tế. Đặc biệt, sản phẩm sử dụng nguồn nguyên liệu hoa bia là hoa hublon tạo nên hương vị đặc trưng của bia được sản xuất từ Đức 
																				 – “cái nôi của công nghệ nấu bia” cùng men bia. BiaTiger được sản xuất trên dây chuyền công nghệ hiện đại, cho ra thành phẩm chất lượng cao,
																				  được đông đảo người tiêu dùng ưa chuộng. Sản phẩm có hương vị thơm nồng, êm dịu mang đến những trải nghiệm thú vị khi thưởng thức.'),
('HNK01','Heineken','5.5%',30,100,'HNK','images/heineken.jpg','2013-06-12',N'• Bia Heineken là một trong những thương hiệu bia nổi tiếng trên toàn thế giới xuất xứ từ Hà Lan. Được chế biến lần đầu tiên vào năm 1870 tại Amsterdam, thương hiệu Heineken được chính thức chào đời vào năm 1873,
																				 khi Gerard Adrian Heineken thành lập nên Heineken & Co. Sau khi đã tiếp quản cơ sở sản xuất bia De Hooiberg ở Amsterdam. Vào thời gian đầu, nhà máy chỉ sản xuất bia cho thị trường trong nước. 
																				 Đầu thế kỷ thứ XX (1912), Heineken tìm cách đưa bia vượt ra khỏi biên giới, xuất sang các nước Bỉ, Anh, Tây Phi, Ấn Độ…. và trở nên nổi tiếng không chỉ ở hương vị ngon đậm đà mà còn ở nét đặc trưng của sản phẩm. 
																				 Năm 1933, Heineken trở thành loại bia ngoại đầu tiên được nhập khẩu vào Mỹ sau khi lệnh cấm sản xuất bia rượu được bãi bỏ và nhanh chóng xây dựng được hình ảnh bia.
																				Heineken luôn khởi nguồn cho những trải nghiệm tuyệt vời, sáng tạo những cuộc chơi thú vị, mở ra những sân chơi riêng biệt và tạo nên những khoảng khắc ấn tượng.
																				 Heineken không ngừng cải tiến và hoàn thiện để mang lại cho khách hàng những giá trị tốt nhất, củng cố vững chắc vị trí thương hiệu trong tâm trí người tiêu dùng.
																				  “Heineken không chỉ là bia, Heineken còn là thế giới của niềm đam mê và sự sảng khoái.”
																				'),
('HNK02','Heineken-Holland','5%',50,200,'HNK','images/heinekenHL.jpg','2014-12-11',N'• Heineken-Holland được tạo ra bởi một nhóm người tận tâm theo đuổi chất lượng cao nhất. 
																					- Hương vị đậm đà. Sự hòa quyện giữa hương vị trái cây, men và mạch nha đem đến cho bạn một thức uống ngon và bổ dưỡng không thể thiếu trong các bữa tiệc thân mật và tình cảm.
																					Chai bia 1 lít này có thiết kế đẹp, màu ấn tượng, mang đến một nguồn năng lượng mới và tình cảm tràn đầy khi nâng ly cùng gia đình và bạn hữu thân thiết.
																					 Thích hợp làm quà biếu tặng trong dịp Lễ.
																					'),
('LR01','Larue','4%',45,30,'BVN','images/larue.jpg','2013-06-04',N'• Beer Larue là loại bia bắt đầu được sản xuất và đặt tên bởi một người Pháp có tên là Victor Larue, 
																	người đã lập lên nhà máy nước đá và nhà máy bia đầu tiên tại Việt Nam vào năm 1909.
																	 Biere Larue Export đã tạo dựng được uy tín là loại bia mang phong cách Châu Âu với chất lượng tốt tại vùng Viễn Đông. 
																	 Tại lễ trao giải thưởng bia Quốc tế 2005 được tổ chức tại Australia, nhãn hiệu Biere Larue Export đã đoạt huy chương vàng và đạt danh hiệu 
																	 “Loại bia mang phong cách châu Âu tuyệt hảo nhất thế giới”.'),
('LR02','Larue-lon','3%',35,20,'BVN','images/laruelon.jpg','2014-02-09',N'• Biere Larue lần đầu tiên được sản xuất vào năm 1909 bởi người Pháp tên Victor Larue. Đây là sản phẩm của sự hòa quyện tinh tế, mang đậm hương vị đặc trưng của hơn 100 năm truyền thống bia Pháp.
																			 Với màu vàng sậm bắt mắt và hậu vị sảng khoái nhờ nguồn nguyên liệu thượng hạng cùng bí quyết nấu bia đến từ Châu Âu. Biere Larue thật hoàn hảo để kết nối tình bạn hữu.
																			Chất lượng hảo hạng từ công thức hoàn mỹ được đúc kết qua nhiều năm kinh nghiệm. Với hương vị tuyệt hảo và sảng khoái được kết tinh từ những nguyên liệu nhập khẩu thượng hạng. 
																			Biere Larue Export sẵn sàng đưa bạn đến mọi cung bậc của cảm xúc.
																			Dạng thành phẩm: Lon'),
																			
('BSG01','Saigon-Red','5%',99,40,'SG','images/saigondo.jpg','2014-11-21',N'• Saigon-red
																			“Không bóng bẩy, không phải ồn ào, không cầu kỳ, không cần phô trương, uống thì hiểu” Saigon Export từ lâu đã là sản phẩm bia được ưa chuộng nhất tại Việt Nam.
																			 Từng giọt bia kết tinh từ tinh thần của con người Sài Gòn mang trọn hương vị truyền thống vừa đậm đà, giản dị mà đầy phóng khoáng. 
																			 Vỏ chai màu nâu mạnh mẽ được bao bọc bởi lớp nhãn ánh kim sang trọng sẽ mang lại cho quý khách hàng những trải nghiệm khó quên. 
																			'),
('BSG02','Saigon-Green','4.5%',88,50,'SG','images/saigonxanh.jpg','2013-03-12',N'• Sai gon xanh “Kết nối tình bằng hữu” Có mặt trên thị trường từ năm 1992, bia Saigon Lager đã và đang nhận được nhiều sự tín nhiệm sử dụng của hàng triệu người uống bia Việt Nam.
																				 Sản xuất trên dây chuyền công nghệ hiện đại tiên tiến hàng đầu thế giới dưới sự điều hành của đội ngũ kỹ thuật giỏi và công nhân lành nghề, bia Saigon Lager đem đến cảm nhận sảng khoái, 
																				 tươi mát và đậm đà cho người sử dụng.'),
('DAB','DAB','7%',88,50,'BK','images/Dab.jpg','2014-12-12',N'• DAB is the ambassador of the famous Dortmund Beer style which is brewed in compliance with the German Beer Purity Law of 1516. 
																Using only pure and natural ingredients, DAB is still brewed in Dortmund to original recipes.
																Over the last 150 years, DAB has become a world famous and international brand as well as a global symbol of German beer culture and a seal of quality.
																Grab your DAB in more than 40 countries!
																'),
('SPR','Sapporo','6%',68,50,'BK','images/sapporo.jpg','2014-12-12',N'• SAPPORO luôn giữ niềm đam mê và cam kết về chất lượng để đem đến những trải nghiệm với sản phẩm chất lượng cao nhất và hiện đại nhất. 
																		SAPPORO PREMIUM BEER 650ml là lời minh chứng rõ ràng nhất. 
																		Thiết kế hiện đại tinh tế lấy cảm hứng từ những chiếc ly cổ điển và được chế tác bởi công nghệ độc đáo của Nhật Bản. 
																		Mẫu lon 650ml ban đầu được dành riêng cho thị trường Bắc Mỹ nhưng nhanh chóng nổi tiếng toàn cầu với thiết kế này.
																		 Nay lon 650ml có mặt tại Việt Nam để được trải nghiệm tuyệt tác của chất lượng của Sapporo Việt Nam.'),
('CRN','Corona','2%',88,50,'BK','images/corona.jpg','2014-12-20',N'• Corona là một trong những loại bia được uống nhiều nhất thế giới. Xuất phát từ Mexico, Corona đã nhanh chóng được dân Bắc Mỹ, châu Âu, châu Úc và cả châu Á. 
																	Thường khi uống, Corona sẽ được phục vụ với một lát chanh cài lên trên miệng chai. Có rất nhiều cách giải thích khác nhau về việc tại sao lại sử dụng chanh như vậy, ví dụ như :
																	•	Chanh được cài lên miệng chai để côn trùng như ruồi, muỗi … không bay vào chai (!)
																	•	Chanh được cài lên miệng chai để đảm bảo rằng miệng chai bia sẽ … vô trùng khi được uống (!). Acid ở trong chanh sẽ quét sạch vi trùng trên miệng chai.
																	Công thức uống Corona với chanh được chính những người sản xuất Corona nghĩ ra và lan truyền ra ngoài. 
																	Vào năm 1981, một anh chàng bartender vô danh đã thử cài chanh vào các chai bia Corona được khách yêu cầu để xem khách có tiếp tục gọi Corona với chanh hay không.
																	'),
('BWS','Budweiser','6%',68,30,'BK','images/budweiser.jpg','2014-12-11',N'• Bia Budweiser là thương hiệu bia đắt giá số 1 thế giới, được sản xuất bằng loại mạch nha cùng với hoa Hops thượng hạng của Hoa Kỳ và Châu Âu. 
																		Sau đó, được ủ 1 tháng trong một thùng gỗ sồi để có vị sạch và giòn tươi. Đây cũng là một trong những loại bia ngọt được rất nhiều người ưa dùng,
																		 điển hình là loại bia này luôn được chọn dùng trong các thế vận hội, World Cup, Olympic,…với số lượng đông đảo người hâm mộ.')


insert into Promotions values
('BSG01','PR09',0,'2015-01-01','2015-02-01'),
('BSG02','PR10',4,'2015-01-01','2015-02-01'),
('DAB','PR11',6,'2015-01-01','2015-02-01'),
('SPR','PR12',3,'2015-01-01','2015-02-01'),
('CRN','PR13',1,'2015-01-01','2015-02-01'),
('BWS','PR14',0,'2015-03-01','2015-04-01'),
('HNK02','PR07',0,'2015-01-01','2015-02-01'),
('LR02','PR08',0,'2015-01-01','2015-02-01'),
('HD01','PR04',9,'2015-03-01','2015-04-01'),
('TG01','PR05',20,'2015-04-01','2015-05-01'),
('TG02','PR06',25,'2015-05-01','2015-06-01'),
('HD02','PR01',5,'2015-01-01','2015-02-01'),
('HNK01','PR02',8,'2015-01-01','2015-02-01'),
('LR01','PR03',5,'2015-01-01','2015-02-01')


insert into Brands values
('BH','Bia Hue'),
('BVN','Bia Viet Nam'),
('HNK','Bia Heiniken'),
('SG','Bia Sai Gon'),
('BK','Bia Ngoai'),
('BVN1','Bia Viet Nam')


--foreign key

Alter table orderdetails
Add constraint FK_orderdetails_beers
Foreign key (beerID)
References Beers(beerID);


Alter table Beers
Add constraint FK_beers_Brands
Foreign key (BrandID)
References Brands(BrandID);


Alter table Promotions
Add constraint FK_promotions_Beers
Foreign key (beerID)
References Beers(BeerID);

Alter table Orderdetails
Add constraint FK_Orderdetails_Orders
Foreign key (orderID)
References Orders(orderID);
                          
CREATE TABLE UserRole (   
  Username VARCHAR(15) NOT NULL primary key,
  Rolename VARCHAR(15) NOT NULL,
  Password varchar(15) NOT NULL,
  Status int ,
);
INSERT INTO UserRole VALUES ('duc', 'manager','12345',1),
                            ('dung', 'admin','12345',1),
                            ('ly', 'admin','12345',1);
