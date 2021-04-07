# Chuck Norris - App de exemplo

## Atividades

1. Adicionar os plugins 'kotlin-android-extensions' e 'kotlin-kapt' e as dependências do [retrofit](https://mvnrepository.com/artifact/com.squareup.retrofit2/retrofit) e [picasso](https://mvnrepository.com/artifact/com.squareup.picasso/picasso) no build.gradle da app
```
/*...*/
plugins {
    /*...*/
    id 'kotlin-android-extensions'
    id 'kotlin-kapt'
    /*...*/
}
/*...*/
dependencies {
    /*...*/
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-jackson:2.9.0'
    implementation 'com.squareup.picasso:picasso:2.8'
    /*...*/
}
/*...*/
```

2. Adicionar permissão de acesso a INTERNET no AndroidManifest.xml
```xml
<uses-permission android:name="android.permission.INTERNET"/>
```

3. Na interface FactService, retirar a interface Call<T> e completar a função getFacts com o seguinte código:
```kotlin
@GET("/jokes/search")
fun getFacts(@Query("query") query: String): Call<Facts>
```

4. Criar a classe FactModelImpl implementando a interface FactModel e o método getFacts da seguinte maneira:
```kotlin
class FactModelImpl: FactModel {

    private val factService = Retrofit.Builder()
        .baseUrl("https://api.chucknorris.io/")
        .addConverterFactory(JacksonConverterFactory.create())
        .build()
        .create(FactService::class.java)

    override fun getFacts(): Facts? {
        return factService.getFacts("dev").execute().body()
    }

}
```

5. Criar a classe FactPresenterImpl implementando a interface FactPresenter e o método obtainFacts com o seguinte corpo:
```kotlin
class FactPresenterImpl(val view: FactView, val model: FactModel): FactPresenter {

    private val handler = Handler(Looper.getMainLooper());
    private val executor = Executors.newCachedThreadPool();

    override fun obtainFacts() {
        executor.execute {
            val facts = model.getFacts()
            handler.post {
                view.onReceived(facts)
            }
        }
    }

}
```

6. Na MainActivity, modificar a propriedade privada factPresenter de:
```kotlin
val factPresenter = object : FactPresenter {
    override fun obtainFacts() {
        TODO("MOCK")
    }
}
```
para
```kotlin
private val factPresenter: FactPresenter = FactPresenterImpl(this, FactModelImpl())
```

7. Retirar, nesta mesma classe, a propriedade factsRecyclerView:
```kotlin
//@TODO MOCK
var factsRecyclerView = RecyclerView(applicationContext)
```

8. Na mesma MainActivity, adicionar seguintes instruções no método onCreate:
```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    factPresenter.obtainFacts()
    factsRecyclerView.layoutManager = LinearLayoutManager(this)
}
```

8. Na classe FactRecyclerViewAdapter.FactsRecyclerViewHolder, implemente o método setData da seguinte maneira:
```kotlin
fun setData(fact: Fact) {
    val imageView = itemView.findViewById<ImageView>(R.id.factImageView)
    Picasso.get()
        .load(fact.icon_url)
        .resize(89,89).into(imageView)
    val textView = itemView.findViewById<TextView>(R.id.factTextView)
    textView.text = fact.value
}
```

9. Na classe FactRecyclerViewAdapter, implemente os métodos onCreateViewHolder, onBindViewHolder e getItemCount() das seguintes maneiras:
```kotlin
override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_main, null)
    return FactsRecyclerViewHolder(itemView)
}

override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    val factsHolder = holder as FactsRecyclerViewHolder
    factsHolder.setData(facts[position])
}

override fun getItemCount() = facts.size
```

10. Volte na MainActivity, e implemente/extenda esta da interface FactView e implemente seu método onReceived:
```kotlin
override fun onReceived(facts: Facts?) {
    if (facts != null) {
        factsRecyclerView.adapter = FactRecyclerViewAdapter(facts.result)
    }
}
```

11. Rode a aplicação

