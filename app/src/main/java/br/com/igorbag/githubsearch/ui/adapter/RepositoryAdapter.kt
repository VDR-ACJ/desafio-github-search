package br.com.igorbag.githubsearch.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.igorbag.githubsearch.R
import br.com.igorbag.githubsearch.domain.Repository
import br.com.igorbag.githubsearch.ui.MainActivity


class RepositoryAdapter(private val repositories: List<Repository>,private val context: Context) :
    RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    var repositoryItemLister: (Repository) -> Unit = {}
    var btnShareLister: (Repository) -> Unit = {}


    // Cria uma nova view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        return ViewHolder(view)
    }

    // Pega o conteudo da view e troca pela informacao de item de uma lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //@TODO 8 -  Realizar o bind do viewHolder -OK
        //Exemplo de Bind
        //  holder.preco.text = repositories[position].atributo

        holder.nomeRepo.text = repositories[position].name

        // Exemplo de click no item
        holder.itemView.setOnClickListener {
         repositoryItemLister(repositories[position])
        }

        // Exemplo de click no btn Share
        holder.linkShare.setOnClickListener {
            btnShareLister(repositories[position])

        }
    }

    // Pega a quantidade de repositorios da lista
    //@TODO 9 - realizar a contagem da lista - OK
    override fun getItemCount(): Int = repositories.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //@TODO 10 - Implementar o ViewHolder para os repositorios - OK
        //Exemplo:
        //val atributo: TextView

        val nomeRepo: TextView
        val linkShare: ImageView


        init {
            view.apply {
                nomeRepo = findViewById(R.id.tv_repo_name)
                linkShare = findViewById(R.id.iv_share)
            }

        }
    }


}


