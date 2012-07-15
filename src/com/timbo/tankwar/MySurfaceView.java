package com.timbo.tankwar;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import static com.timbo.tankwar.Constant.SCREEN_HEIGHT;
import static com.timbo.tankwar.Constant.SCREEN_WIDTH;

import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;

import com.timbo.tankwar.R;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.SoundPool;
import android.view.MotionEvent;

public class MySurfaceView extends SurfaceView implements
		SurfaceHolder.Callback {
	// ============================资源变量 begin============================//
	/**
	 * 子弹位图
	 */
	static Bitmap bullet;
	/**
	 * 英雄子弹位图
	 */
	static Bitmap heroBullet;
	/**
	 * 敌方白坦克
	 */
	static Bitmap[] tanki1;// 坦克位图数组1
	static Bitmap[] tanki2;// 坦克位图数组2
	static Bitmap[] tanki3;// 坦克位图数组3
	/**
	 * 敌方红坦克
	 */
	static Bitmap[] tankRedi1;// 红坦克位图数组1
	static Bitmap[] tankRedi2;// 红坦克位图数组2
	static Bitmap[] tankRedi3;// 红坦克位图数组3
	/**
	 * 英雄坦克
	 */
	static Bitmap[] heroTanki1;// 英雄坦克位图数组1
	static Bitmap[] heroTanki2;// 英雄坦克位图数组2
	static Bitmap[] heroTanki3;// 英雄坦克位图数组3
	static Bitmap[] heroTanki4;// 英雄坦克位图数组4

	/**
	 * 障碍物-砖块，石砖，海洋，草地
	 */
	static Bitmap brickBitmap;
	static Bitmap stoneBitmap;
	static Bitmap seaBitmap;
	static Bitmap iceBitmap;
	static Bitmap grassBitmap;
	/**
	 * 老窝
	 */
	static Bitmap homeBitmap;
	static Bitmap homediedBitmap;
	/**
	 * 奖励物 星星，炸弹，生命，铁铲，保护器，定时器
	 */
	static Bitmap starBitmap;
	static Bitmap bombBitmap;
	static Bitmap lifeBitmap;
	static Bitmap shovelBitmap;
	static Bitmap protectorBitmap;
	static Bitmap timerBitmap;
	/**
	 * 英雄坦克保护器外壳
	 */
	static Bitmap coveringBitmap;
	/**
	 * 虚拟按钮 控制按钮，红点控制器，按下，按上
	 */
	static Bitmap controlBitmap;
	static Bitmap redDotBitmap;
	static Bitmap fireBtnUpBitmap;
	static Bitmap fireBtnDownBitmap;
	/**
	 * 其它 数字，游戏结束，重新开始，声音实现
	 */
	static Bitmap[] numbers;
	static Bitmap gameOver;
	static Bitmap restartBitmap;
	static SoundPool soundPool;
	static Map<Integer, Integer> soundPoolMap;

	static Bitmap dirction_up;
	static Bitmap dirction_back;
	static Bitmap dirction_right;
	static Bitmap dirction_down;
	static int dirction_width;
	static int dirction_height;
	
	// ==================================资源变量over======================================//

	// ============================ 非资源 变量 begin ===============================//
	/**
	 * 地图引用
	 */
	static BattleMap map;
	/**
	 * 英雄引用
	 */
	static Hero hero;
	/**
	 * 按键状态,1——up,2——down,4——left,8——right
	 */
	static int keyState = 0;
	/**
	 * 刷新界面线程标志位 英雄坦克运行标志
	 */
	static boolean heroGoFlag = true;
	/**
	 * 敌方坦克列表
	 */
	static ArrayList<Tank> alTank;
	/**
	 * 随机产生敌方坦克线程的引用
	 */
	private TankGeneratorThread generator;
	/**
	 * 敌方坦克行线程的引用
	 */
	static TankGoThread go;
	/**
	 * 英雄坦克行进线程的引用
	 */
	HeroGoThread heroGo;
	/**
	 * 英雄坦克发射子弹线程的引用
	 */
	static HeroSendBulletThread heroSendBullet;
	/**
	 * 英雄坦克发射子弹的标志位
	 */
	static boolean heroSendBulletFlag = true;
	/**
	 * 敌方坦克随机改变方向线程的引用
	 */
	static TankChangeDirectionThread changeDirection;
	/**
	 * 随机产生坦克的标志位
	 */
	static boolean TankGeneratorFlag = true;
	/**
	 * 英雄坦克行进的标志
	 */
	static boolean TankGoFlag = true;
	/**
	 * 坦克随机改变方向的标志位
	 */
	static boolean TankChangeDirectionFlag = true;
	/**
	 * 英雄子弹列表
	 */
	static Vector<HeroBullet> alHeroBullet;
	/**
	 * 英雄子弹行进线程
	 */
	private HeroBulletGoThread heroBulletGo;
	/**
	 * 英雄子弹标志位
	 */
	static boolean heroBulletGoFlag = true;
	/**
	 * 敌方子弹列表
	 */
	static ArrayList<Bullet> alBullet;
	/**
	 * 敌方坦克发射子弹线程
	 */
	static TankSendBulletThread tankSendBullet;
	/**
	 * 敌方坦克子弹行进线程
	 */
	private TankBulletGoThread tankBulletGo;
	/**
	 * 敌方坦克发送子弹标志位
	 */
	static boolean tankSendBulletFlag = true;
	/**
	 * 敌方坦克子弹行进标志位
	 */
	static boolean tankBulletGoFlag = true;
	/**
	 * 游戏结束标志位
	 */
	static boolean gameOverFlag = false;
	/**
	 * 记录击中坦克数量
	 */
	static int countTankDestoryed = 0;
	/**
	 * 游戏开始时间
	 */
	static long gameStartTime;
	/**
	 * 游戏进行时间
	 */
	static int time = 0;
	/**
	 * 记录游戏界面现在总时间，从开始游戏 到退出游戏
	 */
	static int fullTime = 0;
	/**
	 * 游戏得分
	 */
	static int score = 0;
	/**
	 * 发射按钮是否被按下的标志
	 */
	private boolean fireButtonDownFlag = false;
	/**
	 * 缩放计算的结果类
	 */
	static ScreenScaleResult ssr;

	float dir_x = 630;
	float dir_y = 230;
	// ====================================== 非资源 变量end ===========================================//

	/**
	 * 初始化位图资源
	 */
	private void initBitmap() {
		bullet = BitmapFactory
				.decodeResource(this.getResources(), R.drawable.b);// 创建子弹位图
		heroBullet = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.hb);// 创建子弹位图
		tanki1 = new Bitmap[] {// 创建坦克位图1
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.up1),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.right1),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.down1),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.left1) };
		tanki2 = new Bitmap[] {// 创建坦克位图1
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.up2),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.right2),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.down2),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.left2) };
		tanki3 = new Bitmap[] {// 创建坦克位图2
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.up3),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.right3),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.down3),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.left3) };
		// 英雄坦克
		heroTanki1 = new Bitmap[] {// 创建英雄坦克位图1
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.heroup1),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.heroright1),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.herodown1),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.heroleft1) };
		heroTanki2 = new Bitmap[] {// 创建英雄坦克位图2
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.heroup2),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.heroright2),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.herodown2),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.heroleft2) };
		heroTanki3 = new Bitmap[] {// 创建英雄坦克位图3
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.heroup3),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.heroright3),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.herodown3),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.heroleft3) };
		heroTanki4 = new Bitmap[] {// 创建英雄坦克位图3
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.heroup4),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.heroright4),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.herodown4),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.heroleft4) };
		// 红坦克
		tankRedi1 = new Bitmap[] {// 创建红坦克位图1
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.upred1),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.rightred1),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.downred1),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.leftred1) };
		tankRedi2 = new Bitmap[] {// 创建红坦克位图2
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.upred2),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.rightred2),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.downred2),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.leftred2) };
		tankRedi3 = new Bitmap[] {// 创建红坦克位图3
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.upred3),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.rightred3),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.downred3),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.leftred3) };
		// 障碍物
		brickBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.brick);// 创建砖墙位图
		stoneBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.stone);// 创建石墙位图
		seaBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.sea);// 创建海洋位图
		iceBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.ice);// 创建冰位图
		grassBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.grass);// 创建草地位图
		// 老窝
		homeBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.home);// 创建老窝位图
		homediedBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.homedied);// 创建老窝死后位图
		// 奖励物
		starBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.star);// 星星
		bombBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.bomb);// 炸弹
		lifeBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.life);// 命
		shovelBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.shovel);// 铁锹
		protectorBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.protector);// 保护器
		timerBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.timer);// 定时
		// 外壳
		coveringBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.covering);
		// 数字
		numbers = new Bitmap[] {// 数组位图
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.number0),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.number1),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.number2),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.number3),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.number4),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.number5),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.number6),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.number7),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.number8),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.number9) };
		gameOver = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.gameover);// 游戏结束位图
		restartBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.restart);// 提示重新开始的位图
		controlBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.control);// 虚拟按钮位图
		redDotBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.reddot);// 红点位图
		fireBtnUpBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.fireup);// 发射位图
		fireBtnDownBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.firedown);// 发射位图
		dirction_up = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.up);
		dirction_down = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.down);
		dirction_right = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.right);
		dirction_back = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.back);
		dirction_width = dirction_up.getWidth();
		dirction_height = dirction_up.getHeight();
	}

	// ================================== 非资源方法begin ===================================//

	/**
	 * 游戏结束的方法
	 */
	public static void overGame() {
		gameOverFlag = true;
		TankGeneratorFlag = false;
		heroGoFlag = true;
		TankGoFlag = true;
		TankChangeDirectionFlag = true;
		heroBulletGoFlag = false;
		tankSendBulletFlag = false;
		tankBulletGoFlag = false;
		keyState = 0;// 按键状态置空
	}

	/**
	 * 检测当前任务是否完成的方法
	 */
	public static boolean isCurrentMissionCompleted() {
		return countTankDestoryed >= Constant.TANK_TOTAL_NUM;
	}

	// ================================ 非资源方法end =================================//

	private MySurfaceHolder mysurfaceholder;
	private Paint paint = new Paint();

	public MySurfaceView(Context context) {
		super(context);
		System.out.println("MySurfaceView construction");
		initBitmap();
		this.getHolder().addCallback(this);
		mysurfaceholder = new MySurfaceHolder(this);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		System.out.println("SurfaceView create");
		initAllData();
		mysurfaceholder.setIsplaying(true);
		mysurfaceholder.start();

	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		System.out.println("SurfaceView Destroyed ");
		this.stopAllThreads();// 停止所有线程
		mysurfaceholder.setIsplaying(false);
	}

	public void draw(Canvas canvas) {
		canvas.drawColor(Color.argb(255, 0, 0, 0));// 擦空界面
		// 绘制下层地图
		map.drawSelfBelow(canvas, paint);
		// 绘制英雄坦克
		hero.drawSelf(canvas, paint);
		// 绘制敌方坦克
		ArrayList<Tank> alTank2 = new ArrayList<Tank>(alTank);// 获得当前已存在敌坦克存放列表
		for (Tank t : alTank2) {
			t.drawSelf(canvas, paint);
		}
		// 绘制英雄子弹
		ArrayList<HeroBullet> alHeroBullet2 = new ArrayList<HeroBullet>(
				alHeroBullet);// 复制敌子弹列表
		for (HeroBullet hb : alHeroBullet2) {
			hb.drawSelf(canvas, paint);
		}
		// 绘制敌方子弹
		ArrayList<Bullet> alBullet2 = new ArrayList<Bullet>(alBullet);// 复制敌子弹列表
		for (Bullet b : alBullet2) {
			b.drawSelf(canvas, paint);
		}
		// 绘制上层地图
		map.drawSelfAbove(canvas, paint);
		// 绘制屏幕上侧数据信息
		drawAllDataMessageHP(canvas, paint);
		// 绘制虚拟按键
		drawVirtualButtonHP(canvas, paint);
		// 当游戏结束时，绘制Game Over提示信息
		long currentTime = System.currentTimeMillis();// 记录当前时间
		fullTime = (int) ((currentTime - gameStartTime) / 1000);// 记录游戏总时间

		if (gameOverFlag) {
			if (fullTime % 2 == 0) {// 绘制游戏结束界面
				canvas.drawBitmap(gameOver, SCREEN_WIDTH / 2 - 100,
						SCREEN_HEIGHT / 2 - 26, paint);
				canvas.drawBitmap(restartBitmap, SCREEN_WIDTH / 2 - 100,
						SCREEN_HEIGHT - 120, paint);
			}
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		float y = event.getY();
		float x = event.getX();
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:// ===========按下虚拟键盘==========
			if (// ===== up ===
			Constant.pointIsInRect(x, y, dir_x + dirction_width, dir_y
					- dirction_height, dirction_width, dirction_height)) {
				keyState = (keyState == 0x1) ? 0 : 0x1;
			} else if (// ===== down ===
			Constant.pointIsInRect(x, y, dir_x + dirction_width, dir_y
					+ dirction_height, dirction_width, dirction_height)) {
				keyState = (keyState == 0x2) ? 0 : 0x2;
			} else if (// ===== left ===
			Constant.pointIsInRect(x, y, dir_x, dir_y, dirction_width,
					dirction_height)) {
				keyState = (keyState == 0x4) ? 0 : 0x4;
			} else if (// ===== right ===
			Constant.pointIsInRect(x, y, dir_x + 2 * dirction_width, dir_y,
					dirction_width, dirction_height)) {
				keyState = (keyState == 0x8) ? 0 : 0x8;
			} else if (// ===== fire area ===
			Constant.pointIsInRect(x, y, Constant.FIRE_BTN_X,
					Constant.FIRE_BTN_Y, Constant.FIRE_BTN_WIDTH,
					Constant.FIRE_BTN_HEIGHT)) {
				fireButtonDownFlag = ((fireButtonDownFlag == true) ? false
						: true);
				if (fireButtonDownFlag) {
					heroSendBulletFlag = true;
					heroSendBullet = new HeroSendBulletThread();
					heroSendBullet.start();
				} else {
					heroSendBulletFlag = false;
				}

			}
			// 如果游戏结束，点击重玩的触控区域，重新开始游戏
			if (gameOverFlag) {
				if (Constant.pointIsInRect(x, y, Constant.FIRE_BTN_X,
						Constant.FIRE_BTN_Y, Constant.FIRE_BTN_WIDTH,
						Constant.FIRE_BTN_HEIGHT)) {
					stopAllThreads();// 停止以前所有线程
					initAllData();// 重新初始化所有数据和线程
				}
			}
			break;
		// ===================分界===============================================
		}
		return true;
	}

	// =============================================== HP ====== begin
	// =======
	/**
	 * 绘制屏幕右侧数据信息的方法
	 */
	void drawAllDataMessageHP(Canvas canvas, Paint paint) {
		paint.setColor(Color.RED); // 将画笔颜色设置为灰色
		// 绘制右侧灰色条
		canvas.drawRect(Constant.GAME_VIEW_X + Constant.GAME_VIEW_WIDTH + 1, // left,
				Constant.GAME_VIEW_Y, // top,
				Constant.GAME_VIEW_X + Constant.GAME_VIEW_WIDTH
						+ Constant.RIGHT_BAR, // right,
				Constant.GAME_VIEW_Y + Constant.GAME_VIEW_HEIGHT, // bottom,
				paint);
		paint.setColor(Color.YELLOW); // 将画笔颜色设置为黄色
		paint.setTextSize(13); // 设置字体大小

		drawOneDataMessageHP(5, "得分", score, canvas, paint);
		drawOneDataMessageHP(3, "击毁", countTankDestoryed, canvas, paint);
		drawOneDataMessageHP(4, "英雄", Hero.HEROLIFE, canvas, paint);
		drawOneDataMessageHP(1, "关卡", map.getMissionNum(), canvas, paint);
		drawOneDataMessageHP(2, "敌坦克", Constant.TANK_TOTAL_NUM, canvas, paint);
	}

	void drawOneDataMessageHP(int order, String msg, int number, Canvas canvas,
			Paint paint) {
		// 绘制英雄数量
		canvas.drawText(msg, Constant.GAME_VIEW_X + Constant.GAME_VIEW_WIDTH
				+ Constant.RIGHT_BAR + 2, Constant.GAME_VIEW_Y
				+ Constant.FIRST_MESSAGE_HEIGHT + (order - 1)
				* Constant.HANZI_HEIGHT + (order - 1) * Constant.NUMBER_HEIGHT,
				paint);
		String numberStr = number + "";
		for (int i = 0; i < numberStr.length(); i++) {
			char c = numberStr.charAt(i);
			canvas.drawBitmap(numbers[c - '0'],
					Constant.GAME_VIEW_X + SCREEN_WIDTH - Constant.NUMBER_WIDTH
							* (numberStr.length() - i), Constant.GAME_VIEW_Y
							+ Constant.FIRST_MESSAGE_HEIGHT + order
							* Constant.HANZI_HEIGHT + (order - 1)
							* Constant.NUMBER_HEIGHT, paint);
		}
	}

	/**
	 * 画虚拟按钮的方法
	 * 
	 * @param canvas
	 * @param paint
	 */
	void drawVirtualButtonHP(Canvas canvas, Paint paint) {
		canvas.drawBitmap(dirction_back, dir_x, dir_y, paint);
		canvas.drawBitmap(dirction_up, dir_x + dirction_width, dir_y
				- dirction_height, paint);
		canvas.drawBitmap(dirction_right, dir_x + 2 * dirction_width, dir_y,
				paint);
		canvas.drawBitmap(dirction_down, dir_x + dirction_width, dir_y
				+ dirction_height, paint);
		// 画发射图片
		if (fireButtonDownFlag) {
			canvas.drawBitmap(fireBtnDownBitmap, Constant.FIR_MAP_X,
					Constant.FIR_MAP_Y, paint);
		} else {
			canvas.drawBitmap(fireBtnUpBitmap, Constant.FIR_MAP_X,
					Constant.FIR_MAP_Y, paint);
		}
	}

	// =============================================== HP ====== end =======
	// 按比例画矩形的方法
	void drawColorRect(Canvas canvas, Paint paint, float xLeftTop,
			float yLeftTop, float length, float width // 坐标值在0到1之间
	) {
		canvas.drawRect(xLeftTop, yLeftTop, (xLeftTop + length),
				(yLeftTop + width), paint);
	}

	/**
	 * 初始化所有数据的方法
	 */
	void initAllData() {
		// 要先初始化常量，再初始化地图数据！
		Constant.initConst();// 初始化常量
		map = new BattleMap();// 创建地图对象
		map.intiMapData();// 初始化地图数据
		hero = new Hero(heroTanki1);// 创建英雄坦克对象(位置与常量有关，所以要放在初始化常量和数据后)
		hero.backHome();// 英雄回家
		// 初始化管理列表
		alTank = new ArrayList<Tank>();
		alHeroBullet = new Vector<HeroBullet>();
		alBullet = new ArrayList<Bullet>();
		// 恢复初值
		score = 0;
		countTankDestoryed = 0;
		Hero.HEROLIFE = Constant.HERO_LIFE;
		map.setMissionNum(1);
		map.reward = null;// 清空奖励物
		// 恢复线程标志
		gameOverFlag = false;
		heroGoFlag = true;
		TankGeneratorFlag = true;
		TankGoFlag = true;
		TankChangeDirectionFlag = true;
		heroBulletGoFlag = true;
		tankSendBulletFlag = true;
		tankBulletGoFlag = true;
		// 创建线程
		generator = new TankGeneratorThread();
		go = new TankGoThread();
		heroGo = new HeroGoThread();
		changeDirection = new TankChangeDirectionThread();
		heroBulletGo = new HeroBulletGoThread();
		tankSendBullet = new TankSendBulletThread();
		tankBulletGo = new TankBulletGoThread();
		// 启动线程
		generator.start();
		go.start();
		heroGo.start();
		changeDirection.start();
		heroBulletGo.start();
		tankSendBullet.start();
		tankBulletGo.start();
	}

	// 停止所有线程的方法
	void stopAllThreads() {
		// 将所有控制线程的标志设为false
		heroGoFlag = false;
		TankGeneratorFlag = false;
		TankGoFlag = false;
		TankChangeDirectionFlag = false;
		heroBulletGoFlag = false;
		tankSendBulletFlag = false;
		tankBulletGoFlag = false;
	}

}
