package br.com.cesar.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;


public class ObjectMapper {

    // Instância do mapper (Dozer) responsável por fazer a conversão entre objetos
    // Ele permite mapear automaticamente atributos de uma classe para outra
    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    // Método genérico para converter um objeto em outro Entidade -> DTO ou DTO -> Entidade
    public static <O, D> D parseObject(O origin, Class<D> destination) {

        // Usa o mapper para transformar o objeto de origem (origin)
        // no tipo de destino (destination)
        return mapper.map(origin, destination);
    }

    // Método genérico para converter uma lista de objetos em outra lista de outro tipo
    public static <O, D> List<D> parseListObject(List<O> origin, Class<D> destination) {

        // Cria uma lista que vai armazenar os objetos convertidos
        List<D> destinationObject = new ArrayList<D>();

        // Percorre cada objeto da lista de origem
        for (Object o : origin) {

            // Converte cada objeto individualmente e adiciona na nova lista
            destinationObject.add(mapper.map(o, destination));
        }

        // Retorna a lista já convertida
        return destinationObject;
    }
}
