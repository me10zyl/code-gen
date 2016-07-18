package site.zy1.data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * TCmcard entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TCmcardModel {

	// 成都CODE
	public static final String COMPANY_CODE_CD = "012";
	// 重庆CODE
	public static final String COMPANY_CODE_CQ = "020";
	/**
	 * 已注销
	 */
	public static final int STATUS_CANCELED = -2;
	public static final String STATUS_CANCELED_STR = "已注销";
	/**
	 * 未激活
	 */
	public static final int STATUS_NOT_ACTIVE = -1;
	public static final String STATUS_NOT_ACTIVE_STR = "未激活";
	/**
	 * 禁用
	 */
	public static final int STATUS_DISABLED = 0;
	public static final String STATUS_DISABLED_STR = "禁用";
	/**
	 * 启用
	 */
	public static final int STATUS_ENABLE = 1;
	public static final String STATUS_ENABLE_STR = "启用";
	/**
	 * 已发卡
	 */
	public static final int STATUS_ISSUE = 2;
	public static final String STATUS_ISSUE_STR = "已发卡";
	/**
	 * 已签收
	 */
	public static final int STATUS_RECEIVED = 3;
	public static final String STATUS_RECEIVED_STR = "已签收";

	/**
	 * 实物卡
	 */
	public static final int CARD_CONTENT_TYPE_PRODUCT = 1;
	private Long id;
	private String serialNumber;
	private BigDecimal balance;
	private BigDecimal creditMoney;
	private BigDecimal discount;
	private Integer customerId;
	private Integer cardType;
	private Integer cardLevel;
	private Integer status;
	private Integer createUser;
	private Date createTime;
	private Integer cardChannel;
	private Integer reciptWay;
	private Date carAttbudate;
	private Integer upgradeCardMonth;
	private String companyCode;
	private String company;
	private Integer isVipCard;
	private BigDecimal giftDiscount;
	private String giftSellerPhone;
	private String saler;
	private Integer salerId;
	private Integer mainCardId;
	private Integer acctCustomerId;
	private String acctCustomer;
	private String acctCustomerCode;
	private Date activeTime;
	private BigDecimal activeAmount;
	private Date expireDate;
	private Long issueCardId;
	private Date sendTime;
	// 卡类型（1：实物礼品卡，2：现金礼品卡）
	private Integer cardContentType;
	private String appDescription;
	private Long minAmount;
	private Integer isRecharge;
	private Integer isUpgrade;
	private String description;

	private String createUserName;

	/**
	 * 最多可选产品数
	 */
	private Integer maxProductCount;
	// 客户姓名
	private String customerName;
	/**
	 * 卡原型
	 */
	private String cardLevelName;
	/**
	 * 发卡申请单编号
	 */
	private String issueCardNum;

	/**
	 * 卡内容
	 */
	private String cardTypeName;
	/**
	 * 是否本地卡（0：否， 1：是）
	 */
	private Short isLocal;
	/**
	 * 发卡类型名称
	 */
	private String dictionaryName;
	/**
	 * 卡IDS
	 */
	private List<Long> cardIds;

	// 审核时间
	private Date auditTime;

	// 发卡数量
	private Integer cardCount;

	// 是否仅修改配送范围
	private int isUpdateProduct;

	private String customerCode;

	private Date updateTime;

	/**
	 * 发卡商品
	 */
	private List<CrmIssueCardProductModel> cardProductList;
	private List<CrmIssueCardProductModel> oldCardProductList;

	/**
	 * get status str
	 * 
	 * @param status
	 * @return
	 * @return String
	 * @author ZyL
	 * @date 2016年5月9日 下午1:14:07
	 */
	public static final String statusStr(int status) {
		String returnStr = "";
		switch (status) {
		case STATUS_CANCELED:
			returnStr = STATUS_CANCELED_STR;
			break;
		case STATUS_DISABLED:
			returnStr = STATUS_DISABLED_STR;
			break;
		case STATUS_ENABLE:
			returnStr = STATUS_ENABLE_STR;
			break;
		case STATUS_ISSUE:
			returnStr = STATUS_ISSUE_STR;
			break;
		case STATUS_NOT_ACTIVE:
			returnStr = STATUS_NOT_ACTIVE_STR;
			break;
		case STATUS_RECEIVED:
			returnStr = STATUS_RECEIVED_STR;
			break;
		default:
			break;
		}
		return returnStr;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getCreditMoney() {
		return this.creditMoney;
	}

	public void setCreditMoney(BigDecimal creditMoney) {
		this.creditMoney = creditMoney;
	}

	public BigDecimal getDiscount() {
		return this.discount;
	}

	public String getAcctCustomerCode() {
		return acctCustomerCode;
	}

	public void setAcctCustomerCode(String acctCustomerCode) {
		this.acctCustomerCode = acctCustomerCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getCardType() {
		return this.cardType;
	}

	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Integer getCardLevel() {
		return this.cardLevel;
	}

	public void setCardLevel(Integer cardLevel) {
		this.cardLevel = cardLevel;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCardChannel() {
		return this.cardChannel;
	}

	public void setCardChannel(Integer cardChannel) {
		this.cardChannel = cardChannel;
	}

	public Integer getReciptWay() {
		return this.reciptWay;
	}

	public void setReciptWay(Integer reciptWay) {
		this.reciptWay = reciptWay;
	}

	public Date getCarAttbudate() {
		return this.carAttbudate;
	}

	public void setCarAttbudate(Date carAttbudate) {
		this.carAttbudate = carAttbudate;
	}

	public Integer getUpgradeCardMonth() {
		return this.upgradeCardMonth;
	}

	public void setUpgradeCardMonth(Integer upgradeCardMonth) {
		this.upgradeCardMonth = upgradeCardMonth;
	}

	public String getCompanyCode() {
		return this.companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public Integer getIsVipCard() {
		return this.isVipCard;
	}

	public void setIsVipCard(Integer isVipCard) {
		this.isVipCard = isVipCard;
	}

	public BigDecimal getGiftDiscount() {
		return this.giftDiscount;
	}

	public void setGiftDiscount(BigDecimal giftDiscount) {
		this.giftDiscount = giftDiscount;
	}

	public String getGiftSellerPhone() {
		return this.giftSellerPhone;
	}

	public void setGiftSellerPhone(String giftSellerPhone) {
		this.giftSellerPhone = giftSellerPhone;
	}

	public String getSaler() {
		return this.saler;
	}

	public void setSaler(String saler) {
		this.saler = saler;
	}

	public Integer getSalerId() {
		return this.salerId;
	}

	public void setSalerId(Integer salerId) {
		this.salerId = salerId;
	}

	public Integer getMainCardId() {
		return this.mainCardId;
	}

	public void setMainCardId(Integer mainCardId) {
		this.mainCardId = mainCardId;
	}

	public Integer getAcctCustomerId() {
		return this.acctCustomerId;
	}

	public void setAcctCustomerId(Integer acctCustomerId) {
		this.acctCustomerId = acctCustomerId;
	}

	public String getAcctCustomer() {
		return this.acctCustomer;
	}

	public void setAcctCustomer(String acctCustomer) {
		this.acctCustomer = acctCustomer;
	}

	public String getCardLevelName() {
		return cardLevelName;
	}

	public void setCardLevelName(String cardLevelName) {
		this.cardLevelName = cardLevelName;
	}

	public Long getIssueCardId() {
		return issueCardId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public void setIssueCardId(Long issueCardId) {
		this.issueCardId = issueCardId;
	}

	public String getIssueCardNum() {
		return issueCardNum;
	}

	public void setIssueCardNum(String issueCardNum) {
		this.issueCardNum = issueCardNum;
	}

	public String getCardTypeName() {
		return cardTypeName;
	}

	public void setCardTypeName(String cardTypeName) {
		this.cardTypeName = cardTypeName;
	}

	public Short getIsLocal() {
		return isLocal;
	}

	public void setIsLocal(Short isLocal) {
		this.isLocal = isLocal;
	}

	public String getDictionaryName() {
		return dictionaryName;
	}

	public void setDictionaryName(String dictionaryName) {
		this.dictionaryName = dictionaryName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getActiveTime() {
		return activeTime;
	}

	public void setActiveTime(Date activeTime) {
		this.activeTime = activeTime;
	}

	public BigDecimal getActiveAmount() {
		return activeAmount;
	}

	public void setActiveAmount(BigDecimal activeAmount) {
		this.activeAmount = activeAmount;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public List<Long> getCardIds() {
		return cardIds;
	}

	public void setCardIds(List<Long> cardIds) {
		this.cardIds = cardIds;
	}

	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public Integer getMaxProductCount() {
		return maxProductCount;
	}

	public void setMaxProductCount(Integer maxProductCount) {
		this.maxProductCount = maxProductCount;
	}

	public List<CrmIssueCardProductModel> getCardProductList() {
		return cardProductList;
	}

	public void setCardProductList(List<CrmIssueCardProductModel> cardProductList) {
		this.cardProductList = cardProductList;
	}

	public Integer getCardCount() {
		return cardCount;
	}

	public void setCardCount(Integer cardCount) {
		this.cardCount = cardCount;
	}

	public Integer getCardContentType() {
		return cardContentType;
	}

	public void setCardContentType(Integer cardContentType) {
		this.cardContentType = cardContentType;
	}

	public int getIsUpdateProduct() {
		return isUpdateProduct;
	}

	public void setIsUpdateProduct(int isUpdateProduct) {
		this.isUpdateProduct = isUpdateProduct;
	}

	public List<CrmIssueCardProductModel> getOldCardProductList() {
		return oldCardProductList;
	}

	public void setOldCardProductList(List<CrmIssueCardProductModel> oldCardProductList) {
		this.oldCardProductList = oldCardProductList;
	}

	public String getAppDescription() {
		return appDescription;
	}

	public void setAppDescription(String appDescription) {
		this.appDescription = appDescription;
	}

	public Long getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(Long minAmount) {
		this.minAmount = minAmount;
	}

	public Integer getIsRecharge() {
		return isRecharge;
	}

	public void setIsRecharge(Integer isRecharge) {
		this.isRecharge = isRecharge;
	}

	public Integer getIsUpgrade() {
		return isUpgrade;
	}

	public void setIsUpgrade(Integer isUpgrade) {
		this.isUpgrade = isUpgrade;
	}
}
