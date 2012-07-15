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
	// ============================��Դ���� begin============================//
	/**
	 * �ӵ�λͼ
	 */
	static Bitmap bullet;
	/**
	 * Ӣ���ӵ�λͼ
	 */
	static Bitmap heroBullet;
	/**
	 * �з���̹��
	 */
	static Bitmap[] tanki1;// ̹��λͼ����1
	static Bitmap[] tanki2;// ̹��λͼ����2
	static Bitmap[] tanki3;// ̹��λͼ����3
	/**
	 * �з���̹��
	 */
	static Bitmap[] tankRedi1;// ��̹��λͼ����1
	static Bitmap[] tankRedi2;// ��̹��λͼ����2
	static Bitmap[] tankRedi3;// ��̹��λͼ����3
	/**
	 * Ӣ��̹��
	 */
	static Bitmap[] heroTanki1;// Ӣ��̹��λͼ����1
	static Bitmap[] heroTanki2;// Ӣ��̹��λͼ����2
	static Bitmap[] heroTanki3;// Ӣ��̹��λͼ����3
	static Bitmap[] heroTanki4;// Ӣ��̹��λͼ����4

	/**
	 * �ϰ���-ש�飬ʯש�����󣬲ݵ�
	 */
	static Bitmap brickBitmap;
	static Bitmap stoneBitmap;
	static Bitmap seaBitmap;
	static Bitmap iceBitmap;
	static Bitmap grassBitmap;
	/**
	 * ����
	 */
	static Bitmap homeBitmap;
	static Bitmap homediedBitmap;
	/**
	 * ������ ���ǣ�ը��������������������������ʱ��
	 */
	static Bitmap starBitmap;
	static Bitmap bombBitmap;
	static Bitmap lifeBitmap;
	static Bitmap shovelBitmap;
	static Bitmap protectorBitmap;
	static Bitmap timerBitmap;
	/**
	 * Ӣ��̹�˱��������
	 */
	static Bitmap coveringBitmap;
	/**
	 * ���ⰴť ���ư�ť���������������£�����
	 */
	static Bitmap controlBitmap;
	static Bitmap redDotBitmap;
	static Bitmap fireBtnUpBitmap;
	static Bitmap fireBtnDownBitmap;
	/**
	 * ���� ���֣���Ϸ���������¿�ʼ������ʵ��
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
	
	// ==================================��Դ����over======================================//

	// ============================ ����Դ ���� begin ===============================//
	/**
	 * ��ͼ����
	 */
	static BattleMap map;
	/**
	 * Ӣ������
	 */
	static Hero hero;
	/**
	 * ����״̬,1����up,2����down,4����left,8����right
	 */
	static int keyState = 0;
	/**
	 * ˢ�½����̱߳�־λ Ӣ��̹�����б�־
	 */
	static boolean heroGoFlag = true;
	/**
	 * �з�̹���б�
	 */
	static ArrayList<Tank> alTank;
	/**
	 * ��������з�̹���̵߳�����
	 */
	private TankGeneratorThread generator;
	/**
	 * �з�̹�����̵߳�����
	 */
	static TankGoThread go;
	/**
	 * Ӣ��̹���н��̵߳�����
	 */
	HeroGoThread heroGo;
	/**
	 * Ӣ��̹�˷����ӵ��̵߳�����
	 */
	static HeroSendBulletThread heroSendBullet;
	/**
	 * Ӣ��̹�˷����ӵ��ı�־λ
	 */
	static boolean heroSendBulletFlag = true;
	/**
	 * �з�̹������ı䷽���̵߳�����
	 */
	static TankChangeDirectionThread changeDirection;
	/**
	 * �������̹�˵ı�־λ
	 */
	static boolean TankGeneratorFlag = true;
	/**
	 * Ӣ��̹���н��ı�־
	 */
	static boolean TankGoFlag = true;
	/**
	 * ̹������ı䷽��ı�־λ
	 */
	static boolean TankChangeDirectionFlag = true;
	/**
	 * Ӣ���ӵ��б�
	 */
	static Vector<HeroBullet> alHeroBullet;
	/**
	 * Ӣ���ӵ��н��߳�
	 */
	private HeroBulletGoThread heroBulletGo;
	/**
	 * Ӣ���ӵ���־λ
	 */
	static boolean heroBulletGoFlag = true;
	/**
	 * �з��ӵ��б�
	 */
	static ArrayList<Bullet> alBullet;
	/**
	 * �з�̹�˷����ӵ��߳�
	 */
	static TankSendBulletThread tankSendBullet;
	/**
	 * �з�̹���ӵ��н��߳�
	 */
	private TankBulletGoThread tankBulletGo;
	/**
	 * �з�̹�˷����ӵ���־λ
	 */
	static boolean tankSendBulletFlag = true;
	/**
	 * �з�̹���ӵ��н���־λ
	 */
	static boolean tankBulletGoFlag = true;
	/**
	 * ��Ϸ������־λ
	 */
	static boolean gameOverFlag = false;
	/**
	 * ��¼����̹������
	 */
	static int countTankDestoryed = 0;
	/**
	 * ��Ϸ��ʼʱ��
	 */
	static long gameStartTime;
	/**
	 * ��Ϸ����ʱ��
	 */
	static int time = 0;
	/**
	 * ��¼��Ϸ����������ʱ�䣬�ӿ�ʼ��Ϸ ���˳���Ϸ
	 */
	static int fullTime = 0;
	/**
	 * ��Ϸ�÷�
	 */
	static int score = 0;
	/**
	 * ���䰴ť�Ƿ񱻰��µı�־
	 */
	private boolean fireButtonDownFlag = false;
	/**
	 * ���ż���Ľ����
	 */
	static ScreenScaleResult ssr;

	float dir_x = 630;
	float dir_y = 230;
	// ====================================== ����Դ ����end ===========================================//

	/**
	 * ��ʼ��λͼ��Դ
	 */
	private void initBitmap() {
		bullet = BitmapFactory
				.decodeResource(this.getResources(), R.drawable.b);// �����ӵ�λͼ
		heroBullet = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.hb);// �����ӵ�λͼ
		tanki1 = new Bitmap[] {// ����̹��λͼ1
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.up1),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.right1),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.down1),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.left1) };
		tanki2 = new Bitmap[] {// ����̹��λͼ1
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.up2),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.right2),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.down2),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.left2) };
		tanki3 = new Bitmap[] {// ����̹��λͼ2
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.up3),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.right3),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.down3),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.left3) };
		// Ӣ��̹��
		heroTanki1 = new Bitmap[] {// ����Ӣ��̹��λͼ1
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.heroup1),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.heroright1),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.herodown1),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.heroleft1) };
		heroTanki2 = new Bitmap[] {// ����Ӣ��̹��λͼ2
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.heroup2),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.heroright2),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.herodown2),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.heroleft2) };
		heroTanki3 = new Bitmap[] {// ����Ӣ��̹��λͼ3
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.heroup3),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.heroright3),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.herodown3),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.heroleft3) };
		heroTanki4 = new Bitmap[] {// ����Ӣ��̹��λͼ3
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.heroup4),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.heroright4),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.herodown4),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.heroleft4) };
		// ��̹��
		tankRedi1 = new Bitmap[] {// ������̹��λͼ1
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.upred1),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.rightred1),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.downred1),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.leftred1) };
		tankRedi2 = new Bitmap[] {// ������̹��λͼ2
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.upred2),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.rightred2),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.downred2),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.leftred2) };
		tankRedi3 = new Bitmap[] {// ������̹��λͼ3
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.upred3),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.rightred3),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.downred3),
				BitmapFactory.decodeResource(this.getResources(),
						R.drawable.leftred3) };
		// �ϰ���
		brickBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.brick);// ����שǽλͼ
		stoneBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.stone);// ����ʯǽλͼ
		seaBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.sea);// ��������λͼ
		iceBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.ice);// ������λͼ
		grassBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.grass);// �����ݵ�λͼ
		// ����
		homeBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.home);// ��������λͼ
		homediedBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.homedied);// ������������λͼ
		// ������
		starBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.star);// ����
		bombBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.bomb);// ը��
		lifeBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.life);// ��
		shovelBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.shovel);// ����
		protectorBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.protector);// ������
		timerBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.timer);// ��ʱ
		// ���
		coveringBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.covering);
		// ����
		numbers = new Bitmap[] {// ����λͼ
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
				R.drawable.gameover);// ��Ϸ����λͼ
		restartBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.restart);// ��ʾ���¿�ʼ��λͼ
		controlBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.control);// ���ⰴťλͼ
		redDotBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.reddot);// ���λͼ
		fireBtnUpBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.fireup);// ����λͼ
		fireBtnDownBitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.firedown);// ����λͼ
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

	// ================================== ����Դ����begin ===================================//

	/**
	 * ��Ϸ�����ķ���
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
		keyState = 0;// ����״̬�ÿ�
	}

	/**
	 * ��⵱ǰ�����Ƿ���ɵķ���
	 */
	public static boolean isCurrentMissionCompleted() {
		return countTankDestoryed >= Constant.TANK_TOTAL_NUM;
	}

	// ================================ ����Դ����end =================================//

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
		this.stopAllThreads();// ֹͣ�����߳�
		mysurfaceholder.setIsplaying(false);
	}

	public void draw(Canvas canvas) {
		canvas.drawColor(Color.argb(255, 0, 0, 0));// ���ս���
		// �����²��ͼ
		map.drawSelfBelow(canvas, paint);
		// ����Ӣ��̹��
		hero.drawSelf(canvas, paint);
		// ���Ƶз�̹��
		ArrayList<Tank> alTank2 = new ArrayList<Tank>(alTank);// ��õ�ǰ�Ѵ��ڵ�̹�˴���б�
		for (Tank t : alTank2) {
			t.drawSelf(canvas, paint);
		}
		// ����Ӣ���ӵ�
		ArrayList<HeroBullet> alHeroBullet2 = new ArrayList<HeroBullet>(
				alHeroBullet);// ���Ƶ��ӵ��б�
		for (HeroBullet hb : alHeroBullet2) {
			hb.drawSelf(canvas, paint);
		}
		// ���Ƶз��ӵ�
		ArrayList<Bullet> alBullet2 = new ArrayList<Bullet>(alBullet);// ���Ƶ��ӵ��б�
		for (Bullet b : alBullet2) {
			b.drawSelf(canvas, paint);
		}
		// �����ϲ��ͼ
		map.drawSelfAbove(canvas, paint);
		// ������Ļ�ϲ�������Ϣ
		drawAllDataMessageHP(canvas, paint);
		// �������ⰴ��
		drawVirtualButtonHP(canvas, paint);
		// ����Ϸ����ʱ������Game Over��ʾ��Ϣ
		long currentTime = System.currentTimeMillis();// ��¼��ǰʱ��
		fullTime = (int) ((currentTime - gameStartTime) / 1000);// ��¼��Ϸ��ʱ��

		if (gameOverFlag) {
			if (fullTime % 2 == 0) {// ������Ϸ��������
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
		case MotionEvent.ACTION_DOWN:// ===========�����������==========
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
			// �����Ϸ�������������Ĵ����������¿�ʼ��Ϸ
			if (gameOverFlag) {
				if (Constant.pointIsInRect(x, y, Constant.FIRE_BTN_X,
						Constant.FIRE_BTN_Y, Constant.FIRE_BTN_WIDTH,
						Constant.FIRE_BTN_HEIGHT)) {
					stopAllThreads();// ֹͣ��ǰ�����߳�
					initAllData();// ���³�ʼ���������ݺ��߳�
				}
			}
			break;
		// ===================�ֽ�===============================================
		}
		return true;
	}

	// =============================================== HP ====== begin
	// =======
	/**
	 * ������Ļ�Ҳ�������Ϣ�ķ���
	 */
	void drawAllDataMessageHP(Canvas canvas, Paint paint) {
		paint.setColor(Color.RED); // ��������ɫ����Ϊ��ɫ
		// �����Ҳ��ɫ��
		canvas.drawRect(Constant.GAME_VIEW_X + Constant.GAME_VIEW_WIDTH + 1, // left,
				Constant.GAME_VIEW_Y, // top,
				Constant.GAME_VIEW_X + Constant.GAME_VIEW_WIDTH
						+ Constant.RIGHT_BAR, // right,
				Constant.GAME_VIEW_Y + Constant.GAME_VIEW_HEIGHT, // bottom,
				paint);
		paint.setColor(Color.YELLOW); // ��������ɫ����Ϊ��ɫ
		paint.setTextSize(13); // ���������С

		drawOneDataMessageHP(5, "�÷�", score, canvas, paint);
		drawOneDataMessageHP(3, "����", countTankDestoryed, canvas, paint);
		drawOneDataMessageHP(4, "Ӣ��", Hero.HEROLIFE, canvas, paint);
		drawOneDataMessageHP(1, "�ؿ�", map.getMissionNum(), canvas, paint);
		drawOneDataMessageHP(2, "��̹��", Constant.TANK_TOTAL_NUM, canvas, paint);
	}

	void drawOneDataMessageHP(int order, String msg, int number, Canvas canvas,
			Paint paint) {
		// ����Ӣ������
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
	 * �����ⰴť�ķ���
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
		// ������ͼƬ
		if (fireButtonDownFlag) {
			canvas.drawBitmap(fireBtnDownBitmap, Constant.FIR_MAP_X,
					Constant.FIR_MAP_Y, paint);
		} else {
			canvas.drawBitmap(fireBtnUpBitmap, Constant.FIR_MAP_X,
					Constant.FIR_MAP_Y, paint);
		}
	}

	// =============================================== HP ====== end =======
	// �����������εķ���
	void drawColorRect(Canvas canvas, Paint paint, float xLeftTop,
			float yLeftTop, float length, float width // ����ֵ��0��1֮��
	) {
		canvas.drawRect(xLeftTop, yLeftTop, (xLeftTop + length),
				(yLeftTop + width), paint);
	}

	/**
	 * ��ʼ���������ݵķ���
	 */
	void initAllData() {
		// Ҫ�ȳ�ʼ���������ٳ�ʼ����ͼ���ݣ�
		Constant.initConst();// ��ʼ������
		map = new BattleMap();// ������ͼ����
		map.intiMapData();// ��ʼ����ͼ����
		hero = new Hero(heroTanki1);// ����Ӣ��̹�˶���(λ���볣���йأ�����Ҫ���ڳ�ʼ�����������ݺ�)
		hero.backHome();// Ӣ�ۻؼ�
		// ��ʼ�������б�
		alTank = new ArrayList<Tank>();
		alHeroBullet = new Vector<HeroBullet>();
		alBullet = new ArrayList<Bullet>();
		// �ָ���ֵ
		score = 0;
		countTankDestoryed = 0;
		Hero.HEROLIFE = Constant.HERO_LIFE;
		map.setMissionNum(1);
		map.reward = null;// ��ս�����
		// �ָ��̱߳�־
		gameOverFlag = false;
		heroGoFlag = true;
		TankGeneratorFlag = true;
		TankGoFlag = true;
		TankChangeDirectionFlag = true;
		heroBulletGoFlag = true;
		tankSendBulletFlag = true;
		tankBulletGoFlag = true;
		// �����߳�
		generator = new TankGeneratorThread();
		go = new TankGoThread();
		heroGo = new HeroGoThread();
		changeDirection = new TankChangeDirectionThread();
		heroBulletGo = new HeroBulletGoThread();
		tankSendBullet = new TankSendBulletThread();
		tankBulletGo = new TankBulletGoThread();
		// �����߳�
		generator.start();
		go.start();
		heroGo.start();
		changeDirection.start();
		heroBulletGo.start();
		tankSendBullet.start();
		tankBulletGo.start();
	}

	// ֹͣ�����̵߳ķ���
	void stopAllThreads() {
		// �����п����̵߳ı�־��Ϊfalse
		heroGoFlag = false;
		TankGeneratorFlag = false;
		TankGoFlag = false;
		TankChangeDirectionFlag = false;
		heroBulletGoFlag = false;
		tankSendBulletFlag = false;
		tankBulletGoFlag = false;
	}

}
