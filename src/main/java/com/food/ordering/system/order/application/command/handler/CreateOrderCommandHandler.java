package com.food.ordering.system.order.application.command.handler;

import com.food.ordering.system.order.application.command.CreateOrderCommand;
import com.food.ordering.system.order.application.dto.response.OrderResponse;
import com.food.ordering.system.order.application.mapper.OrderMapper;
import com.food.ordering.system.order.domain.model.Order;
import com.food.ordering.system.order.domain.repository.OrderEventPublisherPort;
import com.food.ordering.system.order.domain.repository.OrderRepositoryPort;
import com.food.ordering.system.shared.application.cqrs.CommandHandler;
import com.food.ordering.system.shared.domain.event.DomainEvent;
import com.food.ordering.system.shared.domain.valueobject.CustomerId;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Handles {@link CreateOrderCommand}.
 * Orchestrates domain creation, persistence and event publishing.
 */
@Component
@Transactional
public class CreateOrderCommandHandler
        implements CommandHandler<CreateOrderCommand, OrderResponse> {

    private final OrderRepositoryPort orderRepository;
    private final OrderEventPublisherPort eventPublisher;

    public CreateOrderCommandHandler(OrderRepositoryPort orderRepository,
                                     OrderEventPublisherPort eventPublisher) {
        this.orderRepository = orderRepository;
        this.eventPublisher  = eventPublisher;
    }

    @Override
    public OrderResponse handle(CreateOrderCommand command) {
        // La capa de aplicación traduce el String externo al Value Object del dominio
        CustomerId customerId = CustomerId.of(command.customerId());
        Order order = Order.create(customerId, command.totalAmount());
        Order saved = orderRepository.save(order);

        for (DomainEvent event : saved.getDomainEvents()) {
            eventPublisher.publish(event);
        }
        saved.clearDomainEvents();

        return OrderMapper.toResponse(saved);
    }
}

