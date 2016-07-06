package com.finance.brid.entity;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * Status : 1
	 * Msg : 登录成功
	 * ReturnObject : {"Oauth":null,"Password":"12345678","NickName":"呃呃","Pingying":"","Sex":1,"Birthday":"","Intro":"没有什么了不起的","Qq":null,"Email":"","Sign":null,"Status":1,"Update_datetime":"/Date(-62135596800000)/","Create_datetime":"/Date(-62135596800000)/","Address":{"Status":0,"Province":null,"City":null,"County":null,"Addr":null,"Zip":null,"Consignee":null,"Email":null,"UserID":null,"Mobile":null,"Code":null,"RemoteIp":null},"Name":"测试","Province":"上海市","City":"上海市","County":"","Addr":"","Profession":"","Face":"http://data.finance365.org/i/201604/","Degree":"","Age":1,"Account":null,"Industry":"","Position":"","School":"","Major":"","Source":null,"CoinTotal":0,"DfwCount":10,"InviteCode":"DHDMTb","InviteNumber":0,"FriendId":null,"Ccb_userId":0,"Grade":"","ProfessionStatus":"","LargeFace":"http://data.finance365.org/i/201604/201507241044367728_180.jpg","SmallFace":"http://data.finance365.org/i/201604/201507241044367728_50.jpg","UserID":"201507241044367728","Mobile":"15174331793","Code":null,"RemoteIp":null}
	 */

	private int Status;
	private String Msg;
	/**
	 * Oauth : null
	 * Password : 12345678
	 * NickName : 呃呃
	 * Pingying :
	 * Sex : 1
	 * Birthday :
	 * Intro : 没有什么了不起的
	 * Qq : null
	 * Email :
	 * Sign : null
	 * Status : 1
	 * Update_datetime : /Date(-62135596800000)/
	 * Create_datetime : /Date(-62135596800000)/
	 * Address : {"Status":0,"Province":null,"City":null,"County":null,"Addr":null,"Zip":null,"Consignee":null,"Email":null,"UserID":null,"Mobile":null,"Code":null,"RemoteIp":null}
	 * Name : 测试
	 * Province : 上海市
	 * City : 上海市
	 * County :
	 * Addr :
	 * Profession :
	 * Face : http://data.finance365.org/i/201604/
	 * Degree :
	 * Age : 1
	 * Account : null
	 * Industry :
	 * Position :
	 * School :
	 * Major :
	 * Source : null
	 * CoinTotal : 0
	 * DfwCount : 10
	 * InviteCode : DHDMTb
	 * InviteNumber : 0
	 * FriendId : null
	 * Ccb_userId : 0
	 * Grade :
	 * ProfessionStatus :
	 * LargeFace : http://data.finance365.org/i/201604/201507241044367728_180.jpg
	 * SmallFace : http://data.finance365.org/i/201604/201507241044367728_50.jpg
	 * UserID : 201507241044367728
	 * Mobile : 15174331793
	 * Code : null
	 * RemoteIp : null
	 */

	private ReturnObjectEntity ReturnObject;

	public int getStatus() {
		return Status;
	}

	public void setStatus(int Status) {
		this.Status = Status;
	}

	public String getMsg() {
		return Msg;
	}

	public void setMsg(String Msg) {
		this.Msg = Msg;
	}

	public ReturnObjectEntity getReturnObject() {
		return ReturnObject;
	}

	public void setReturnObject(ReturnObjectEntity ReturnObject) {
		this.ReturnObject = ReturnObject;
	}

	public static class ReturnObjectEntity implements Serializable{
		private Object Oauth;
		private String Password;
		private String NickName;
		private String Pingying;
		private int Sex;
		private String Birthday;
		private String Intro;
		private Object Qq;
		private String Email;
		private Object Sign;
		private int Status;
		private String Update_datetime;
		private String Create_datetime;
		/**
		 * Status : 0
		 * Province : null
		 * City : null
		 * County : null
		 * Addr : null
		 * Zip : null
		 * Consignee : null
		 * Email : null
		 * UserID : null
		 * Mobile : null
		 * Code : null
		 * RemoteIp : null
		 */

		private AddressEntity Address;
		private String Name;
		private String Province;
		private String City;
		private String County;
		private String Addr;
		private String Profession;
		private String Face;
		private String Degree;
		private int Age;
		private Object Account;
		private String Industry;
		private String Position;
		private String School;
		private String Major;
		private Object Source;
		private int CoinTotal;
		private int DfwCount;
		private String InviteCode;
		private int InviteNumber;
		private Object FriendId;
		private int Ccb_userId;
		private String Grade;
		private String ProfessionStatus;
		private String LargeFace;
		private String SmallFace;
		private String UserID;
		private String Mobile;
		private Object Code;
		private Object RemoteIp;

		public Object getOauth() {
			return Oauth;
		}

		public void setOauth(Object Oauth) {
			this.Oauth = Oauth;
		}

		public String getPassword() {
			return Password;
		}

		public void setPassword(String Password) {
			this.Password = Password;
		}

		public String getNickName() {
			return NickName;
		}

		public void setNickName(String NickName) {
			this.NickName = NickName;
		}

		public String getPingying() {
			return Pingying;
		}

		public void setPingying(String Pingying) {
			this.Pingying = Pingying;
		}

		public int getSex() {
			return Sex;
		}

		public void setSex(int Sex) {
			this.Sex = Sex;
		}

		public String getBirthday() {
			return Birthday;
		}

		public void setBirthday(String Birthday) {
			this.Birthday = Birthday;
		}

		public String getIntro() {
			return Intro;
		}

		public void setIntro(String Intro) {
			this.Intro = Intro;
		}

		public Object getQq() {
			return Qq;
		}

		public void setQq(Object Qq) {
			this.Qq = Qq;
		}

		public String getEmail() {
			return Email;
		}

		public void setEmail(String Email) {
			this.Email = Email;
		}

		public Object getSign() {
			return Sign;
		}

		public void setSign(Object Sign) {
			this.Sign = Sign;
		}

		public int getStatus() {
			return Status;
		}

		public void setStatus(int Status) {
			this.Status = Status;
		}

		public String getUpdate_datetime() {
			return Update_datetime;
		}

		public void setUpdate_datetime(String Update_datetime) {
			this.Update_datetime = Update_datetime;
		}

		public String getCreate_datetime() {
			return Create_datetime;
		}

		public void setCreate_datetime(String Create_datetime) {
			this.Create_datetime = Create_datetime;
		}

		public AddressEntity getAddress() {
			return Address;
		}

		public void setAddress(AddressEntity Address) {
			this.Address = Address;
		}

		public String getName() {
			return Name;
		}

		public void setName(String Name) {
			this.Name = Name;
		}

		public String getProvince() {
			return Province;
		}

		public void setProvince(String Province) {
			this.Province = Province;
		}

		public String getCity() {
			return City;
		}

		public void setCity(String City) {
			this.City = City;
		}

		public String getCounty() {
			return County;
		}

		public void setCounty(String County) {
			this.County = County;
		}

		public String getAddr() {
			return Addr;
		}

		public void setAddr(String Addr) {
			this.Addr = Addr;
		}

		public String getProfession() {
			return Profession;
		}

		public void setProfession(String Profession) {
			this.Profession = Profession;
		}

		public String getFace() {
			return Face;
		}

		public void setFace(String Face) {
			this.Face = Face;
		}

		public String getDegree() {
			return Degree;
		}

		public void setDegree(String Degree) {
			this.Degree = Degree;
		}

		public int getAge() {
			return Age;
		}

		public void setAge(int Age) {
			this.Age = Age;
		}

		public Object getAccount() {
			return Account;
		}

		public void setAccount(Object Account) {
			this.Account = Account;
		}

		public String getIndustry() {
			return Industry;
		}

		public void setIndustry(String Industry) {
			this.Industry = Industry;
		}

		public String getPosition() {
			return Position;
		}

		public void setPosition(String Position) {
			this.Position = Position;
		}

		public String getSchool() {
			return School;
		}

		public void setSchool(String School) {
			this.School = School;
		}

		public String getMajor() {
			return Major;
		}

		public void setMajor(String Major) {
			this.Major = Major;
		}

		public Object getSource() {
			return Source;
		}

		public void setSource(Object Source) {
			this.Source = Source;
		}

		public int getCoinTotal() {
			return CoinTotal;
		}

		public void setCoinTotal(int CoinTotal) {
			this.CoinTotal = CoinTotal;
		}

		public int getDfwCount() {
			return DfwCount;
		}

		public void setDfwCount(int DfwCount) {
			this.DfwCount = DfwCount;
		}

		public String getInviteCode() {
			return InviteCode;
		}

		public void setInviteCode(String InviteCode) {
			this.InviteCode = InviteCode;
		}

		public int getInviteNumber() {
			return InviteNumber;
		}

		public void setInviteNumber(int InviteNumber) {
			this.InviteNumber = InviteNumber;
		}

		public Object getFriendId() {
			return FriendId;
		}

		public void setFriendId(Object FriendId) {
			this.FriendId = FriendId;
		}

		public int getCcb_userId() {
			return Ccb_userId;
		}

		public void setCcb_userId(int Ccb_userId) {
			this.Ccb_userId = Ccb_userId;
		}

		public String getGrade() {
			return Grade;
		}

		public void setGrade(String Grade) {
			this.Grade = Grade;
		}

		public String getProfessionStatus() {
			return ProfessionStatus;
		}

		public void setProfessionStatus(String ProfessionStatus) {
			this.ProfessionStatus = ProfessionStatus;
		}

		public String getLargeFace() {
			return LargeFace;
		}

		public void setLargeFace(String LargeFace) {
			this.LargeFace = LargeFace;
		}

		public String getSmallFace() {
			return SmallFace;
		}

		public void setSmallFace(String SmallFace) {
			this.SmallFace = SmallFace;
		}

		public String getUserID() {
			return UserID;
		}

		public void setUserID(String UserID) {
			this.UserID = UserID;
		}

		public String getMobile() {
			return Mobile;
		}

		public void setMobile(String Mobile) {
			this.Mobile = Mobile;
		}

		public Object getCode() {
			return Code;
		}

		public void setCode(Object Code) {
			this.Code = Code;
		}

		public Object getRemoteIp() {
			return RemoteIp;
		}

		public void setRemoteIp(Object RemoteIp) {
			this.RemoteIp = RemoteIp;
		}

		public static class AddressEntity {
			private int Status;
			private Object Province;
			private Object City;
			private Object County;
			private Object Addr;
			private Object Zip;
			private Object Consignee;
			private Object Email;
			private Object UserID;
			private Object Mobile;
			private Object Code;
			private Object RemoteIp;

			public int getStatus() {
				return Status;
			}

			public void setStatus(int Status) {
				this.Status = Status;
			}

			public Object getProvince() {
				return Province;
			}

			public void setProvince(Object Province) {
				this.Province = Province;
			}

			public Object getCity() {
				return City;
			}

			public void setCity(Object City) {
				this.City = City;
			}

			public Object getCounty() {
				return County;
			}

			public void setCounty(Object County) {
				this.County = County;
			}

			public Object getAddr() {
				return Addr;
			}

			public void setAddr(Object Addr) {
				this.Addr = Addr;
			}

			public Object getZip() {
				return Zip;
			}

			public void setZip(Object Zip) {
				this.Zip = Zip;
			}

			public Object getConsignee() {
				return Consignee;
			}

			public void setConsignee(Object Consignee) {
				this.Consignee = Consignee;
			}

			public Object getEmail() {
				return Email;
			}

			public void setEmail(Object Email) {
				this.Email = Email;
			}

			public Object getUserID() {
				return UserID;
			}

			public void setUserID(Object UserID) {
				this.UserID = UserID;
			}

			public Object getMobile() {
				return Mobile;
			}

			public void setMobile(Object Mobile) {
				this.Mobile = Mobile;
			}

			public Object getCode() {
				return Code;
			}

			public void setCode(Object Code) {
				this.Code = Code;
			}

			public Object getRemoteIp() {
				return RemoteIp;
			}

			public void setRemoteIp(Object RemoteIp) {
				this.RemoteIp = RemoteIp;
			}
		}
	}
}
