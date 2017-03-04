[top](../index.html) / [index](index.html) / [target](https://igapyon.github.io/diary/memo/memowinxptune.html) / [source](https://github.com/igapyon/diary/blob/master/memo/memowinxptune.src.md) 

資料: Windows XP 設定＆チューニングメモ
=====================================================================================================
[![いがぴょん画像(小)](https://igapyon.github.io/diary/images/iga200306s.jpg "いがぴょん")](https://igapyon.github.io/diary/memo/memoigapyon.html) 日記形式でつづる [いがぴょん](https://igapyon.github.io/diary/memo/memoigapyon.html)コラム ウェブページです。

[old-v2](memowinxptune-orig.html)

私のための Windows XP 設定やチューニングのメモです。とりあえず今回は あまりデフォルトからは変更しないという方針で考えています。

## 資料: Windows XP 設定＆チューニングメモ

[いがぴょんのウェブページトップへ戻る](../../index.html)

## 基本的な設定

* パスワードを設定
  (デフォルトにおいてパスワード無しでインストールされるっていうのに驚愕)
  
* 登録された拡張子の非表示をOFF化
  
* 全てのファイルを表示するように変更
  
* リモートデスクトップを有効化

## サービスパック

* Windows XP SP2を適用しました (2004.10.11)
  
* ファイアウォール設定およびウイルス対策については、Norton Internet Security
  2004 を使用するせっていにしました (2004.10.11)

## デスクトップ周り設定

* 壁紙をコーヒーカップに変更。
  
* キーボードの反応速度を最速に変更
  
* スクリーンセーバー → モニタ電源 について、
  
  * モニタの電源を切る : 5分後
    
  * ハードディスクの電源を切る : 5分後
  

サービスを片っ端から停止したいところですけれども、その技は とりあえず後回しにしています。

## カーネル周りチューニング

よくあるカーネル周りチューニングのメモです。Windows XP に関しては、どうしてもしょうがないものだけチューニングする方針です。
Windows Registry Editor Version 5.00
[HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control\Session Manager\Memory Management]
      "DisablePagingExecutive"=dword:00000001
      "IoPageLockLimit"=dword:00010000
      [HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control\FileSystem]
      "NtfsDisableLastAccessUpdate"=dword:00000001

* カーネルを実メモリのみに展開 : DisablePagingExecutive
  デフォルト : "DisablePagingExecutive"=dword:00000000
  
* ファイルシステム割り当てメモリを増加 : IoPageLockLimit
  デフォルト : なし
  キロバイト表記だそうです。dword:00010000 は 16進表記で、10進換算で 64MBに相当します。(こう考えると
  ディスクキャッシュを有効にメモリ展開するunixに比べると どうも Windows は気に入りません)
  あと 綴りに注意。loではなくIoだったのです。というのも、インターネットでざっくり検索したら、loで間違っているページが幾つも見つかったのですもの。(私は当初loで書いて 効果が全く出ずに 大変不思議に思ったから 特にそのように思います)
  
* アクセス日時の更新をOFF : NtfsDisableLastAccessUpdate
  デフォルト : なし
  ★ ずいぶんI/O削減効果が出るように感じました。なにせOSデフォルト状態では
  ファイルの読み込みだけなのに書き込みが発生するのですから。ファイル読み込みだけでもプリプリとHDDアクセスが発生してしまうデフォルト状態に比べると
  ものすごく良いです。そしてそのデフォルト挙動は ふつうに(unix的に)考えると
  とても悪いことですよねぇ。

あと、書き込みキャッシュ遅延とか あるはずなんだけれども、ちょっと見つけられず…。というかあんましきわどいチューニングは止めておきましょう (苦笑)

2001/12/01 [林信一](http://www.angelwaltz.net/)さんからツッコミこんにちは、林です。偶然ですが、私もXPへ開発環境をしています。ドキュメント作らないといけないのですが、officeがすこぶる不調で、仕方なくHD増設してXPをインストールしています。今までの環境は、NT３．５１からアップグレードを続けてきたWin2000だったからか、HDの速度の違いか、体感速度が格段にアップしました（苦笑）また、こんなページもみつけました。高速化などいろいろあります。QAとしてもなかなかいい感じです。

* [http://pc-information.com/](http://pc-information.com/)

では。

## 導入ソフト

* 秀丸エディタ
  
* 鶴亀メール
  
* LHMelting
  
* プリンタドライバ (CANON BJ F660)
  
* Matrox G400 ディスプレイドライバ
  (Matroxからダウンロードの最新版)
  
* たいむぼっか～ん
  Windows XP 付属のNTPクライアントは イマイチでした
  
* Googleツールバー for IE
  
* 一太郎V11
  
* ウィルスバスター2001
  (インストール直後に最新版へネットワーク経由で更新)
  
* IBM ホームページビルダー V6 (アップグレード版)
  
* IBM WorkPad Desktop
  ただし HotSyncプログラムの常駐時には CPU消費バグが発生してしまう模様なのですが…
  →Palm Desktop 4.0.1がPalmからダウンロード可能になっていて、これを利用したら、CPU消費バグは改善されて、大変快適になりました。

## Windows XP 上で動作しなかったソフト

* ×Adaptec Easy CD Creator 4 (結構昔から愛用してきたもの)
  仕方がないのでバージョンアップ版の購入を検討。なれど XP対応 Easy CD Creator
  5 は いつ出てくるのだろうか… (苦笑)
  # 後日談: Windows XP側にパッチを当てたら動作した可能性があります…。今さら知っても…
  
* ×B's Recorder GOLD 1.99 (CD-R購入時に付いてきたもの)

CD-R焼き付けソフトは 悲しいかな予想通り全滅です。昔購入したバージョンを ず～っと使い続けるというのは 難しいことなのですね
(T_T)

2002/02/15 読者の方からツッコミわらやです。いつもどうもです。ツッコミというより、情報なのですが・・・いがぴょんさんは「Windows XP 上で動作しなかったソフト」として「B's Recorder
GOLD 1.99」をあげてらっしゃいますが、このソフトは確か無償で3.19(2/15時点)にバージョンアップすることができ,かつこれはWindowsXPに対応しているようです。

* [http://www.bha.co.jp/download/gold_w/index.html](http://www.bha.co.jp/download/gold_w/index.html)

私自身はXPにまだ触れたことがないので本当に動作するかはわからないのですが。
BHAは無償で(現在のところ)最新版にバージョンアップしてくれるので個人的にはスキです。というか、商売っ気がないですね。ではでは。

## 感想

Windows 2000に比べて I/O周りの体感速度が向上しています。というのも バスマスタI/Oとかまじめに設定せずに OS認識のまま利用することが多かったので、デフォルトでバスマスタI/Oなどを自動認識する Windows XP は Windows 2000に比べると I/O周りが高速なのです。結構気に入ってきました。

ただし タスクマネージャを呼びだしたときの反応速度などは低下しているようです。これは不満。OSのタイムスライスが長く設定されている？のでしょうか。# いいかげんな事を言ったらいけませんが :-Pあと やっぱり Windows 2000 に比べると安定感が低下しているように思います。

特に気に入ったのは 『リモートデスクトップ』機能です。これは欲しい機能です。VNCとはひと味違った Xサーバ的挙動が とっても気に入りました。

## 更新履歴

* 2004/10/11 Windows XP SP2に関する説明を ほんの少しだけ追記
  
* 2002/02/15 バグ修正
  
* 2001/11/30 新規作成

----------------------------------------------------------------------------------------------------

## この日記について

[Share on Twitter](https://twitter.com/intent/tweet?hashtags=igapyon%2Cdiary%2C%E3%81%84%E3%81%8C%E3%81%B4%E3%82%87%E3%82%93&text=%E8%B3%87%E6%96%99%3A+Windows+XP+%E8%A8%AD%E5%AE%9A%EF%BC%86%E3%83%81%E3%83%A5%E3%83%BC%E3%83%8B%E3%83%B3%E3%82%B0%E3%83%A1%E3%83%A2&url=https%3A%2F%2Figapyon.github.io%2Fdiary%2Fmemo%2Fmemowinxptune.html) / [top](../index.html) / [いがぴょんについて](https://igapyon.github.io/diary/memo/memoigapyon.html) / [Powered by Igapyonv3](https://github.com/igapyon/igapyonv3)
