[old-v2](memojavastyle-orig.html)

Java言語ソースファイルのスタイル整形に関するメモ。astyleやcheckstyleなどのメモ書きが含まれます。

## 資料: Java言語ソースファイルのスタイルおよび調整ツール
[いがぴょんのウェブページトップへ戻る](../../index.html)
## Java言語コーディング規約

そもそも Java言語コーディング規約にまつわるものとして、下記があります。(そしてこの２つが有名です)

* Java言語コーディング規約
  [http://www.tcct.zaq.ne.jp/ayato/programming/java/codeconv_jp/](http://www.tcct.zaq.ne.jp/ayato/programming/java/codeconv_jp/)
  Java Code Conventions の沼田哲史さんの手による日本語訳
  
* 頑健なJavaプログラムの書き方(Writing Robust Java Code 日本語訳)
  [http://www.alles.or.jp/~torutk/oojava/codingStandard/](http://www.alles.or.jp/~torutk/oojava/codingStandard/)
  高橋徹さんの手による日本語訳

オマケ

* 沼田哲史 (NUMATA Satoshi) さんのページ
  [http://numata.aquasky.jp/](http://numata.aquasky.jp/)

以下はEclipse主体です

## Eclipseのソースコード・フォーマッタによるソースコード整形

オープンソースなJava統合開発環境として有名なEclipseには ソースコード・フォーマッタが標準搭載されています。基本的に Java言語の標準的な規約に従ったソースコード整形を行ってくれます。(完全に
Java言語コーディング規約に合致していない点に注意)

## Eclipse Checkstyleプラグイン

転記する気力が萎えてしまいました

* [http://homepage2.nifty.com/igat/igapyon/diary/2004/ig040209.html](http://homepage2.nifty.com/igat/igapyon/diary/2004/ig040209.html)

## Eclipse PMDプラグイン

転記する気力が萎えてしまいました

* [http://homepage2.nifty.com/igat/igapyon/diary/2004/ig040209.html](http://homepage2.nifty.com/igat/igapyon/diary/2004/ig040209.html)

## Eclipse FindBugsプラグイン

* [http://homepage2.nifty.com/igat/igapyon/diary/2004/ig040219.html](http://homepage2.nifty.com/igat/igapyon/diary/2004/ig040219.html)

以下はコマンドライン主体です

## Javaソースファイル整形ツール Artistic Style (astyle)

* Artistic Style (astyle) 1.15.3
  [http://astyle.sourceforge.net/](http://astyle.sourceforge.net/)
  [http://sourceforge.net/projects/astyle/](http://sourceforge.net/projects/astyle/)
  GPLライセンス

通称astyleという、GPLライセンスなJavaソースファイル整形ツールです。astyle -j --style=java -p -s ファイル名.java のようにスイッチを使うと、[Java言語コーディング規約](http://www.tcct.zaq.ne.jp/ayato/programming/java/codeconv_jp/) にそこそこ合致したソースコードを得ることが出来ます。

## Javaソースファイル構文チェックツール checkstyle

* Checkstyle
  [http://checkstyle.sourceforge.net/](http://checkstyle.sourceforge.net/)
  LGPLライセンス

様々な Java構文合致状態をチェックしてくれるツールです。こちらは astyleとは異なり自動整形はしてくれません。その代わり かなり正確に[Java言語コーディング規約](http://www.tcct.zaq.ne.jp/ayato/programming/java/codeconv_jp/)との整合性チェックを報告してくれます。

* java -classpath checkstyle-all-2.3.jar com.puppycrawl.tools.checkstyle.Main
  ファイル名.java

## お好みツール

上記を組み合わせて お好みなバッチを作成して使っています。
st.batecho off
rem Javaソースファイルのスタイル整形＆チェックツール
echo astyle実行
astyle -j --style=java -p -s %1 %2 %3 %4 %5 %6 %7 %8 %9
rem checkstyle-all-2.3.jar を CLASSPATHが通ったところに配置してください。
echo checkstyle実行
      java com.puppycrawl.tools.checkstyle.Main %1
      
      diff -urN %1.orig %1
これで st ファイル名.java のように指定すれば、ソースファイル整形とソースファイルのスタイルチェックとがいっぺんに起動できます。

## 更新履歴

* 2004/02/24 Eclipseに対応開始
  
* 2002/07/10 新規作成