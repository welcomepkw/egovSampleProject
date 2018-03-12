egovSampleProject
=============


Contents
-------------
1. eGov
2. 설정정보
3. mybatis
4. tiles
5. transaction
6. ehcache
7. lombok
8. samples
9. change log


eGov
-------------
* version : 3.6.0


설정 정보
-------------
* spring
	* location : /src/main/resources/config/spring/*.xml
* database
	* location : /src/main/resources/config/database/${SERVER_MOD}/database.properties
	* description : 실행 OS 의 환경변수 'SERVER_MOD' 의 값에 따라 폴더 변경하여 'database.properties' 값 참조. 환경변수 없을경우 local
* system
	* location1 : /src/main/resources/config/system/${SERVER_MOD}/application.properties
		* 서버별 system 참조 값
	* location2 : /src/main/resources/config/system/common.properties
		* 공통 system 참조 값
* ehcache
	* location : /src/main/resources/ehcache.xml	
* tiles
	* location : /src/main/resources/tiles.xml
* log4j2
	* location : /src/main/resources/log4j2.xml
	

mybatis
-------------	
* version : 3.3.0
* xml location : src/main/sql/{packages}/*.xml
* description : 동일한 class, xml 명으로 자동 검색하여 매핑 하도록 설정.


tiles
-------------
* version : 3.0.5
* xml config location : /src/main/resources/tiles.xml
* decoration jsp location : /src/main/webapp/WEB-INF/jsp/layout/*.jsp


transaction
-------------
* description
	* TransactionService.java -> @Transactional 참조
	
ehcache
-------------
* description
	* SampleMapper.java -> @Cacheable 참조
	* 파라미터값이 변경될 경우 ehcache.xml 파일의 정보를 참조하여 룰에 의해 cache 생성
	
lombok
-------------
* version : 1.16.20
* description
	* value object 의 getter setter 자동 생성을 위해 사용
	* TSample.java -> @Getter, @Setter, @ToString 참조

samples
-------------
* CRUD samples
	* common info
		* controller : SampleController.java
		* service : SampleService.java
		* mapper : SampleMapper.java, Samplemapper.xml
	* read : /sample/list.do
	* create : /sample/create.do
	* update : /sample/update.do	
* Transaction Sample
	* common info
		* controller : TransactionController.java
		* service : TransactionService.java
		* mapper : SampleMapper.java, Samplemapper.xml
	* test : /transaction/test.do?id=17&text1=abcd&text2=efg
* Cache Sample
	* common info
		* controller : CacheController.java
		* service : CacheService.java
		* mapper : SampleMapper.java, Samplemapper.xml
	* test : /cache/test.do?id=17
	* description : console 의 로그상 서버 구동 후 1회 조회시 sql log 보인 후 같은 id로 2회 차 조회시 sql log 보이지 않을경우 cache 정상 작동.
* file upload Sample
	* common info
		* controller : FileController.java
		* util : FileUpload.java
		* settings : context-fileUpload.xml, context-customBeans.xml
	* test : /file/file.do
	* description : /KAL_DEV/upload 에 파일 업로드 기능 구현. browser로 업로드 파일 test 하기 위해서는 local PC 에 web server 구동 필요.
	
change log
-------------
* 18.03.07
	* @Valid 작동이 안되고 있어 수정.
		* dispatch-servlet.xml 에 <mvc:annotation-driven /> 추가, pom.xml 에 hibernate-validator 추가
	* web.xml 에 exception 핸들링 추가 및 ErrorController.java, exception.jsp 추가
	* file upload 기능 구현.
		* samples -> file upload Sample 참조
	* 일부 controller 에서 response 값을 json 으로 출력하기 위해 하던 프로세스를 @responsebody 로 전환.
	* dispatch-servlet.xml 에 interceptor 설정 변경
	* /src/main/resources/config/database 와 /src/main/resources/config/system 에 각 서버 별 빈 설정파일 추가. 
* 18.03.08
	* egov paging 처리 추가 및 기존 list 출력 샘플 query 수정
	
	
	
#####
