Kotlin Updates in LL2019
===

2019-08-24 [@eyasuyuki](https://twitter.com/eyasuyuki)

<!-- paginate: true -->

---

# Kotlinとは(1/3)

https://kotlinlang.org/

![Kotlin Website](https://raw.githubusercontent.com/eyasuyuki/KotlinUpdates/master/images/kotlinlang_org.png)

---

# Kotlinとは(2/3)

- JetBrainsが開発したコンパイラ言語
    - JVMバイトコードへのコンパイル
    - JavaScriptへのトランスパイル
    - LLVM中間表現へのコンパイル
- Null安全
- スマートキャスト
- データクラス (ボイラープレートからの解放)
- 高速なコンパイル (Scalaに対する優位性)

---

# Kotlinとは(3/3)

- 関数型言語からの影響
	- ラムダ式
	- 高階関数
	- 末尾再帰
	- 多値
	- パターンマッチ
	- 型推論
	- ifなどが構文ではなく式(値を返す)
	- 中値記法

---

# Kotlin躍進のきっかけ

- 2017年のGoogle I/OでAndroidの開発言語として正式に採用された

---

# Kotlinの歴史(1/2)

バージョン1.0未満は省略しました。

|年月|バージョン|主なトピック|
|----|----------|------------|
|2016年2月|1.0|Javaとの完全互換<br>Java6バイトコードへのコンパイル|
|2017年5月||Androidの開発言語として正式採用|
|2017年3月|1.1|JavaScript対応<br>コルーチン(実験的) async/await,yield<br>Java9サポート<br>コンパイル速度の向上|

---

# Kotlinの歴史(2/2)

|年月|バージョン|主なトピック|
|----|----------|------------|
|2017年11月|1.2|マルチプラットフォームプロジェクト(実験的)|
|2018年11月|1.3|コルーチン<br>Kotlin/Native<br>契約(Contracts)|

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

# マルチプラットフォームプロジェクト(実験的)

- 1つのプロジェクトで複数ターゲットのビルドが可能
- ```build.gradle```などに記述
- ```gradle init```でプロジェクトが作れる訳ではない(テンプレートがない)
- 参考文献: https://kotlinlang.org/docs/reference/building-mpp-with-gradle.html

---

# Java対応

- 当初のメリット:
    - Java6でもラムダ式や関数型言語的なプログラミングができる
- Java8以降が広く使われるようになり当初のメリットは薄れた
- Kotlin自体もJava8以降のバイトコードに対応できるようになた

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

- ```async```
    - ```Deferred<T>```を返すコルーチンビルダー関数
- ```await```
    - ```Deferred<T>```のサスペンド関数
- ```yield```, ```yieldAll```
    - サスペンド関数。その時点で中断して値を返す
- Channel
    - コルーチン間で値を送受信できるキュー (like Golang)

---

# async(1/2)

![async1](https://raw.githubusercontent.com/eyasuyuki/KotlinUpdates/master/images/async1.png)

実行結果:
```aidl
start async
end async
```

---

# async(2/2)
![async2](https://raw.githubusercontent.com/eyasuyuki/KotlinUpdates/master/images/async2.png)

実行結果:
```aidl
start async
Inside async
end async
```

---

# await(1/2)

![await1](https://raw.githubusercontent.com/eyasuyuki/KotlinUpdates/master/images/await1.png)

コンパイルエラー:
![compile_error](https://raw.githubusercontent.com/eyasuyuki/KotlinUpdates/master/images/compile_error.png)

---

# await (2/2)

![await2](https://raw.githubusercontent.com/eyasuyuki/KotlinUpdates/master/images/await2.png)

実行結果:
```aidl
start runBlocking
Hello world.
end runBlocking
```

---

# asyncな関数(1/2)

![async_fun1](https://raw.githubusercontent.com/eyasuyuki/KotlinUpdates/master/images/async_fun1.png)

---

# asyncな関数(2/2)

使い方:
![async_fun2](https://raw.githubusercontent.com/eyasuyuki/KotlinUpdates/master/images/async_fun2.png)

実行結果
```aidl
start async function
Hello, async.
end async function
```

---

# 契約(Contracts)

- スマートキャストの判定を改善するための宣言
- 関数が呼び出された後の状態を制約してスマートキャストが効くようにする

---

# スマートじゃないキャスト(Java)

![dumb](https://raw.githubusercontent.com/eyasuyuki/KotlinUpdates/master/images/dumb.png)

---

# スマートキャスト

![smart](https://raw.githubusercontent.com/eyasuyuki/KotlinUpdates/master/images/smart.png)

---

# 契約(Contracts)のおさらい

- スマートキャストの判定を改善するための宣言
- 関数が呼び出された後の状態を制約してスマートキャストが効くようにする
- 参考文献: https://speakerdeck.com/ntaro/kotlin-contracts-number-m3kt

---

# Kotlinの書籍(1/2)

- 長澤太郎「Kotlinスタートブック」2016 (通称赤べこ本)
- 長澤太郎「Kotlin Webアプリケーション」2017

![Taro's Books](https://raw.githubusercontent.com/eyasuyuki/KotlinUpdates/master/images/books1.jpg)

---

# Kotlinの書籍(2/2)

- Dmitry Jemerov/Svetlana Isakova "Kotlin in Action" 2017 (訳書あり)
- Pierre-Yves Saumont "Joy of Kotlin" 2019

![Manning](https://raw.githubusercontent.com/eyasuyuki/KotlinUpdates/master/images/books2.jpg)

---

# このスライドのソースとサンプルコード

https://github.com/eyasuyuki/KotlinUpdates


