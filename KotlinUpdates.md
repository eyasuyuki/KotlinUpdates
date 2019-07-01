Kotlin Updates in LL2019
===

2019-08-24 [@eyasuyuki](https://twitter.com/eyasuyuki)

---

# Kotlinとは(1/2)

https://kotlinlang.org/

![Kotlin Website](https://raw.githubusercontent.com/eyasuyuki/KotlinUpdates/master/images/kotlinlang_org.png)

---

# Kotlinとは(2/2)

- JetBrainsが開発したコンパイラ言語
    - JVMバイトコード
    - JavaScriptへのトランスパイル
    - LLVM中間表現
- Null安全
- 関数型言語からの影響
	- ラムダ式
	- 高階関数
	- 末尾再帰
	- 多値
	- パターンマッチ
	- 型推論
	- ifなどが構文ではなく式(値を返す)
	- 中値記法
- スマートキャスト
- データクラス (ボイラープレートからの解放)
- 高速なコンパイル (Scalaに対する優位性)

---

# Kotlin躍進のきっかけ

- 2017年のGoogle I/OでAndroidの開発言語として正式に採用された

---

# 1.0から1.3までの大きなトピック

- マルチプラットフォーム対応
- コルーチン
- 契約(Contracts)

---

# マルチプラットフォーム対応

- 当初はJavaとの完全互換が大きなメリットだった
    - JavaとKotlinが混在しても動作するので部分的に移行することも可能
- 次いでJavaScriptへの対応が行われ、フロントエンドもKotlinで開発出来るようになった
- Kotlin/Nativeのリリースでネイティブコンパイルが可能になりJavaに依存しない道が開かれた
- 適用分野:
    - 当初はAndroid開発が主な用途
    - 現在ではサーバーサイドからフロントエンドまで全てKotlinで開発できる

---

# Java対応

- 当初はJava6でもラムダ式や関数型言語的なプログラミングができるのがメリットだった
- Javaのバージョンアップによってこれらの要素がJavaに取り込まれメリットは薄れてきた
- Kotlin自体もJava8以降のバイトコードに対応できるようになって行った

---

# JavaScript対応

- とりあえずKotlinからJavaScriptにトランスパイルはできる
- TypeScriptやDartと比べて便利かというと...🤔
- Kotlin/NativeでWebAssemblyにコンパイルする方が有望...?
- 参考文献: https://speakerdeck.com/subroh0508/jstoge-dou-sinagarakotlinfalseiketeruwen-fa-woxue-bu

---

# Kotlin/Native

- KotlinからLLVM中間表現へコンパイル
    - Linux
    - Windows
    - Android NDK
    - iOS
    - macOS
    - WebAssembly
- 当然ながらJavaのライブラリは使えない
- iOSアプリがKotlinで書ける
- 参考文献: https://www.slideshare.net/TakakiHoshikawa/kotlinnative

---

# コルーチン

- async/await
- yield

---

# 契約(Contracts)

- スマートキャストの判定を改善するための宣言
- 関数が呼び出された後の状態を制約してスマートキャストが効くようにする
- 参考文献: https://speakerdeck.com/ntaro/kotlin-contracts-number-m3kt

---

# Kotlinの書籍

- 長澤太郎「Kotlinスタートブック」2016 (通称赤べこ本)
- 長澤太郎「Kotlin Webアプリケーション」2017
- Dmitry Jemerov/Svetlana Isakova "Kotlin in Action" 2017 (訳書あり)
- Pierre-Yves Saumont "Joy of Kotlin" 2019

![Taro's Books](https://raw.githubusercontent.com/eyasuyuki/KotlinUpdates/master/images/books1.jpg)

![Manning](https://raw.githubusercontent.com/eyasuyuki/KotlinUpdates/master/images/books2.jpg)
