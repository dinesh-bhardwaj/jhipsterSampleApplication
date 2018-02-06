/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { RNS_DEL_PLACE_MASTERDeleteDialogComponent } from '../../../../../../main/webapp/app/entities/rns-del-place-master/rns-del-place-master-delete-dialog.component';
import { RNS_DEL_PLACE_MASTERService } from '../../../../../../main/webapp/app/entities/rns-del-place-master/rns-del-place-master.service';

describe('Component Tests', () => {

    describe('RNS_DEL_PLACE_MASTER Management Delete Component', () => {
        let comp: RNS_DEL_PLACE_MASTERDeleteDialogComponent;
        let fixture: ComponentFixture<RNS_DEL_PLACE_MASTERDeleteDialogComponent>;
        let service: RNS_DEL_PLACE_MASTERService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterSampleApplicationTestModule],
                declarations: [RNS_DEL_PLACE_MASTERDeleteDialogComponent],
                providers: [
                    RNS_DEL_PLACE_MASTERService
                ]
            })
            .overrideTemplate(RNS_DEL_PLACE_MASTERDeleteDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(RNS_DEL_PLACE_MASTERDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RNS_DEL_PLACE_MASTERService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it('Should call delete service on confirmDelete',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        spyOn(service, 'delete').and.returnValue(Observable.of({}));

                        // WHEN
                        comp.confirmDelete(123);
                        tick();

                        // THEN
                        expect(service.delete).toHaveBeenCalledWith(123);
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                    })
                )
            );
        });
    });

});
